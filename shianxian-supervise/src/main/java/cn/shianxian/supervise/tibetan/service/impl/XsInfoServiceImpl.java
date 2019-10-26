package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.IncreaseUtil;

import cn.shianxian.supervise.tibetan.dao.XsInfoDao;
import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Result saveSalesInfo(List<XsInfoVO> xsInfoVO,String xspaydm,String xspaymc) {
        // 根据进货批次号排序
        Collections.sort(xsInfoVO, new Comparator<XsInfoVO>() {
            @Override
            public int compare(XsInfoVO o1, XsInfoVO o2) {
                return o1.getJhdm().compareTo(o2.getJhdm());
            }
        });
        HashMap<Object, Object> map = new HashMap<>();
        // 销售总金额
        BigDecimal totalAmount = new BigDecimal(0);

        SEQUENCE = SEQUENCE >= 999999 ? 1 : SEQUENCE + 1;
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String sequence = Integer.toString(SEQUENCE);
        String increase = IncreaseUtil.addLeftZero(sequence, LENGTH);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date());
        for (XsInfoVO infoDTO : xsInfoVO) {
            infoDTO.setXspaydm(xspaydm);
            infoDTO.setXspaymc(xspaymc);
            // 销售金额
            BigDecimal xsje = infoDTO.getXsje();
            totalAmount = xsje.add(totalAmount);
            map.put("totalAmount", totalAmount);
//            // 销售日期
//            infoDTO.setXsrq(time);
            // 销售商品编码
            infoDTO.setXsdm(datetime + increase);
            // 插入主表
            String mainInfo = xsInfoDao.insertSalesMainInfo(infoDTO);
//            if (StringUtils.isNotBlank(mainInfo) || Integer.parseInt(mainInfo) > 0) {
            //
            infoDTO.setXsspdm(increase);
            // 插入从表
            String subInfo = xsInfoDao.insertSalesSubInfo(infoDTO);
//                if (StringUtils.isNotBlank(subInfo) || Integer.parseInt(subInfo) > 0) {
            map.put("xsdm", infoDTO.getXsdm());
            return Result.data(map);
//                }
//                return Result.msg("插入销售从表失败");
//            }
//            return Result.msg("插入销售主表失败");
        }
        return Result.failMsg();
    }

    @Override
    public Result selectXsInfo(XsMain xsMain) {
        XsInfoDTO xsInfoDTO = this.xsInfoDao.selectXsInfo(xsMain);
        return Result.data(xsInfoDTO);
    }

    @Override
    @Transactional
    public Result saveAmount(List<XsMainInfoVO> xsInfoVO) {
       if (!xsInfoVO.isEmpty()){
           for (XsMainInfoVO infoVO : xsInfoVO) {
               // 销售总金额
               BigDecimal amount = infoVO.getAmount();
               // 下家金额
               BigDecimal xsje = xsInfoDao.selectXsje(infoVO.getXsxjdm());
               // 根据销售编码查询上家编码
               String xssjdm = xsInfoDao.selectXssjdmByXsdm(infoVO.getXsdm());
               // 上家金额
               BigDecimal sjje = xsInfoDao.selectXsje(xssjdm);

               if (xsje.compareTo(amount) > -1) {
                   // 更新销售主表信息
                   xsInfoDao.updateXsMainInfo(infoVO);
                   // 下家余额 = 下家金额 - 销售总金额
                   BigDecimal xjye = xsje.subtract(amount);
                   xsInfoDao.updateKhBalance(xjye,infoVO.getXsxjdm());

                   // 上家余额 = 上家金额 + 销售总金额
                   BigDecimal sjye = sjje.add(amount);
                   xsInfoDao.updateKhBalance(sjye,xssjdm);
                   return Result.successMsg();
               }
               return Result.msg("余额不足，交易失败！");
           }
       }
        return Result.msg("参数为空！");
    }

    @Override
    public Result updateCheckByXsdm(XsMain xsMains) {
        this.xsInfoDao.updateCheck(xsMains);
        return Result.successMsg();
    }

}
