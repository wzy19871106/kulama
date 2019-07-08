package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.POIUtils;
import cn.shianxian.supervise.info.dao.SuperviseInfoOldDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoOldImportDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOld;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOldImport;
import cn.shianxian.supervise.info.service.SuperviseInfoOldService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class SuperviseInfoOldServiceImpl implements SuperviseInfoOldService {


    @Autowired
    private SuperviseInfoOldDao superviseInfoOldDao;


    @Autowired
    private SuperviseInfoOldImportDao superviseInfoOldImportDao;


    @Transactional
    @Override
    public ResponseEntity<Result> importSuperviseInfoOld(MultipartFile file) throws IOException {
        // 从第3列开始，每6列为一条数据。例如：3-8为一组数据，9-14为一组数据
        int flag = 3;
        String fileName = file.getOriginalFilename();
        // 校验Excel
        int tyep = POIUtils.checkFile(fileName);
        // 获取Excel
        Workbook workbook = null;
        if (1 == tyep) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } if (2 == tyep) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = workbook.getSheetAt(0);
        Integer num = sheet.getLastRowNum();
        if (num <= 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.msg("该Excel为空，请重新上传！"));
        }
        Set<SuperviseInfoOld> superviseInfoOlds = new TreeSet<>();
        // 前5行跳过
        for (int i = 5; i <= sheet.getLastRowNum(); i++) {
            SuperviseInfoOld info = new SuperviseInfoOld();
            // 共57列，第0列为编号丢弃，第1列企业名称
            String cell1 = POIUtils.getCellValue(sheet.getRow(i), 1);
            info.setNodeName(cell1);
            // 第2列，地址
            String cell2 = POIUtils.getCellValue(sheet.getRow(i), 1);
            info.setNodeAddress(cell2);
            // 集合添加数据
            superviseInfoOlds = this.setBeanList(superviseInfoOlds, info, sheet.getRow(i), flag);
        }
        // 批量写入入数据
        this.superviseInfoOldDao.batchInsertSelective(superviseInfoOlds);
        // 将数据写入导入表
        SuperviseInfoOldImport oldImport = new SuperviseInfoOldImport();
        oldImport.setFileName(fileName);
        oldImport.setImportResult("1");
        oldImport.setImportTime(LocalDateTime.now());
        this.superviseInfoOldImportDao.saveSuperviseInfoOldImport(oldImport);
        return ResponseEntity.ok(Result.successMsg());
    }


    // 获取Excel数据
    private Set<SuperviseInfoOld> setBeanList(Set<SuperviseInfoOld> superviseInfoOlds, SuperviseInfoOld info, Row row, int flag) {
        if (flag <= 51) {
            for (int k = flag; k <= flag + 5; k++) {
                Cell cell = row.getCell(k);
                if (k == 3 || k == 3 + 6 || k == 3 + 6 * 2 || k == 3 + 6 * 3 || k == 3 + 6 * 4 || k == 3 + 6 * 5 || k == 3 + 6 * 6 || k == 3 + 6 * 7 || k == 3 + 6 * 8) {
                    // 判断第3列不符合项序号是否为空，为空则不添加
                    if (cell == null || StringUtils.isBlank(POIUtils.getCellValue(row, k))) {
                        SuperviseInfoOld infoOld = new SuperviseInfoOld();
                        infoOld.setNodeName(info.getNodeName());
                        infoOld.setNodeAddress(info.getNodeAddress());
                        // 修改标识
                        return this.setBeanList(superviseInfoOlds, infoOld, row, flag + 6);
                    }
                    // 第3列为不符合项序号，以后的每列加6之后的数据是一样的，
                    String value = POIUtils.getCellValue(row, k);
                    if (value.contains("*")) {
                        value = value.replace("*", "");
                    }
                    info.setSuperviseTypeTag(String.valueOf(Math.floor(Double.valueOf(value))));
                    info.setUnMatchId(POIUtils.getCellValue(row, k));
                } else if (k == 4 || k == 4 + 6 || k == 4 + 6 * 2 || k == 4 + 6 * 3 || k == 4 + 6 * 4 || k == 4 + 6 * 5 || k == 4 + 6 * 6 || k == 4 + 6 * 7 || k == 4 + 6 * 8) {
                    // 第4列，不符合检查要点项
                    info.setUnMatchPointId(POIUtils.getCellValue(row, k));
                } else if (k == 5 || k == 5 + 6 || k == 5 + 6 * 2 || k == 5 + 6 * 3 || k == 5 + 6 * 4 || k == 5 + 6 * 5 || k == 5 + 6 * 6 || k == 5 + 6 * 7 || k == 5 + 6 * 8) {
                    // 第5列，问题数
                    info.setWrongNum(POIUtils.getCellValue(row, k));
                } else if (k == 6 || k == 6 + 6 || k == 6 + 6 * 2 || k == 6 + 6 * 3 || k == 6 + 6 * 4 || k == 6 + 6 * 5 || k == 6 + 6 * 6 || k == 6 + 6 * 7 || k == 6 + 6 * 8) {
                    // 第6列，不符合内容
                    info.setUnMatchContent(POIUtils.getCellValue(row, k));
                } else if (k == 7 || k == 7 + 6 || k == 7 + 6 * 2 || k == 7 + 6 * 3 || k == 7 + 6 * 4 || k == 7 + 6 * 5 || k == 7 + 6 * 6 || k == 7 + 6 * 7 || k == 7 + 6 * 8) {
                    // 第7列，整改措施
                    info.setRequst(POIUtils.getCellValue(row, k));
                } else if (k == 8 || k == 8 + 6 || k == 8 + 6 * 2 || k == 8 + 6 * 3 || k == 8 + 6 * 4 || k == 8 + 6 * 5 || k == 8 + 6 * 6 || k == 8 + 6 * 7 || k == 8 + 6 * 8) {
                    // 第8列，回访落实情况（是：1否：0）
                    info.setReturnVisitDone(POIUtils.getCellValue(row, k));
                }
            }
            info.setIfDelete(0);
            info.setSuperviseTime(LocalDateTime.now());
            superviseInfoOlds.add(info);
            SuperviseInfoOld infoOld = new SuperviseInfoOld();
            infoOld.setNodeName(info.getNodeName());
            infoOld.setNodeAddress(info.getNodeAddress());
            // 修改标识
            return this.setBeanList(superviseInfoOlds, infoOld, row, flag + 6);
        }
        return superviseInfoOlds;
    }


    @Override
    public Result selectSuperviseInfoOld(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        Example example = new Example(SuperviseInfoOld.class);
        example.setOrderByClause("superviseTime DESC");
        Example.Criteria criteria = example.createCriteria();
        List<SuperviseInfoOld> list = new ArrayList<>();
        if (queryPojo.getId() != null) {
            criteria.andEqualTo("id", queryPojo.getId());
        }
        if (StringUtils.isNotBlank(queryPojo.getName())) {
            criteria.andEqualTo("nodeName", queryPojo.getName());
        }
        if (queryPojo.getStartTime() != null && queryPojo.getEndTime() != null) {
            criteria.andBetween("superviseTime", queryPojo.getStartTime(), queryPojo.getEndTime());
        }
        list = this.superviseInfoOldDao.selectByExample(example);
        return Result.data(page.getTotal(), list);
    }


    @Override
    public Result selectSuperviseInfoOldGroup(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<SuperviseInfoOld> list = this.superviseInfoOldDao.selectSuperviseInfoOldGroup(queryPojo);
        return Result.data(page.getTotal(), list);
    }


}
