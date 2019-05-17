package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseResultDao;
import cn.shianxian.supervise.sys.dto.SuperviseResultDTO;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import cn.shianxian.supervise.sys.service.SuperviseResultService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperviseResultServiceImpl implements SuperviseResultService {


    @Autowired
    private SuperviseResultDao superviseResultDao;


    @Transactional
    @Override
    public ResponseEntity<Result> saveSuperviseResult(SuperviseResult superviseResult) {
        SuperviseResult result = this.superviseResultDao.selectByPrimaryKey(superviseResult.getResultTag());
        if (null != result) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Result.msg("编码已存在！"));
        }
        this.superviseResultDao.insertSuperviseResult(superviseResult);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public Result updateSuperviseResult(SuperviseResult superviseResult) {
        this.superviseResultDao.updateSuperviseResult(superviseResult);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteSuperviseResultById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviseResultDao.deleteSuperviseResult(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviseResult(SuperviseResult superviseResult, Pages pages) {
        List<SuperviseResult> results = new ArrayList<>();
        if (StringUtils.isNotBlank(superviseResult.getResultTag())) {
            results = this.superviseResultDao.selectSuperviseResultById(superviseResult.getResultTag());
        }
        if (StringUtils.isNotBlank(superviseResult.getSuperviseTag())) {
            results = this.superviseResultDao.selectSuperviseResultBySuperviseTag(superviseResult.getSuperviseTag());
        }
        return Result.data(results);
    }


    @Transactional
    @Override
    public Result updateSuperviseResultBySort(String id, int type) {
        if (1 == type) {
            this.superviseResultDao.updateSuperviseResultByUpSort(id);
        }
        if (2 == type) {
            this.superviseResultDao.updateSuperviseResultByDownSort(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseResultByTypeId(String typeId) {
        List<SuperviseResultDTO> list = this.superviseResultDao.selectSuperviseResultByTypeId(typeId);
        return Result.data(list);
    }
}
