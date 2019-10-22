package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.IncreaseUtil;

import cn.shianxian.supervise.tibetan.dao.XsInfoDao;
import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class XsInfoServiceImpl implements XsInfoService {
    @Autowired
    private XsInfoDao xsInfoDao;

    private static int SEQUENCE = 0;

    private static int LENGTH = 6;

    @Override
    public Result saveSalesInfo(List<XsInfoVO> xsInfoVO) {
        // 根据进货批次号排序
        Collections.sort(xsInfoVO, new Comparator<XsInfoVO>() {
            @Override
            public int compare(XsInfoVO o1, XsInfoVO o2) {
                return o1.getJhdm().compareTo(o2.getJhdm());
            }
        });
        HashMap<Object, Object> map = new HashMap<>();
        // 总金额
       BigDecimal totalAmount = new BigDecimal(0);

        SEQUENCE = SEQUENCE >= 999999 ? 1 : SEQUENCE + 1;
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String sequence = Integer.toString(SEQUENCE);
        String increase = IncreaseUtil.addLeftZero(sequence, LENGTH);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date());
        for (XsInfoVO infoDTO : xsInfoVO) {
            // 销售金额
            BigDecimal xsje = infoDTO.getXsje();
            totalAmount = xsje.add(totalAmount);
            map.put("totalAmount",totalAmount);
            // 销售日期
            infoDTO.setXsrq(time);
            // 销售商品编码
            infoDTO.setXsspdm(datetime + increase);
            String mainInfo = xsInfoDao.insertSalesMainInfo(infoDTO);
            if (StringUtils.isNotBlank(mainInfo) || Integer.parseInt(mainInfo) > 0) {
                // 进货批次号
                infoDTO.setJhdm(increase);
                String subInfo = xsInfoDao.insertSalesSubInfo(infoDTO);
                if (StringUtils.isNotBlank(subInfo) || Integer.parseInt(subInfo) > 0){
                    map.put("xsspdm",infoDTO.getXsspdm());
                    return Result.data(map);
                }
                return Result.msg("插入销售从表失败");
            }
            return Result.msg("插入销售主表失败");
        }
        return Result.failMsg();
    }

    @Override
    public Result selectXsInfo(String xssjdm, String xsxjdm, String xschecked) {
        XsInfoDTO xsInfoDTO = this.xsInfoDao.selectXsInfo(xssjdm, xsxjdm, xschecked);
        return Result.data(xsInfoDTO);
    }

}
