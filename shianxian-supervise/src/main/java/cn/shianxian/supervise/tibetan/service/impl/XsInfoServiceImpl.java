package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.IncreaseUtil;

import cn.shianxian.supervise.tibetan.dao.XsInfoDao;
import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.pojo.XsSub;
import cn.shianxian.supervise.tibetan.vo.XsInfoSaveVO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import cn.shianxian.supervise.tibetan.vo.XsVerificationVO;
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
    public Result saveSalesInfo(XsInfoSaveVO xsInfoVO) {
        // 根据进货批次号排序
        Collections.sort(xsInfoVO.getXsInfoVO(), new Comparator<XsInfoVO>() {
            @Override
            public int compare(XsInfoVO o1, XsInfoVO o2) {
                return o1.getJhdm().compareTo(o2.getJhdm());
            }
        });
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        // 销售总金额
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal totalWeight  = new BigDecimal(0);
        SEQUENCE = SEQUENCE >= 999999 ? 1 : SEQUENCE + 1;
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String sequence = Integer.toString(SEQUENCE);
        String increase = IncreaseUtil.addLeftZero(sequence, LENGTH);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date());
        List<XsInfoVO> infoVOS = xsInfoVO.getXsInfoVO();
        for (XsInfoVO infoDTO : infoVOS) {
            // 销售金额
            BigDecimal xsje = infoDTO.getXsje();
            BigDecimal xszl = infoDTO.getXszl();

            totalWeight = xszl.add(totalWeight);
            totalAmount = xsje.add(totalAmount);
            infoDTO.setXsspdm(increase);
            infoDTO.setXsdm(datetime + increase);
            // 插入从表
            this.xsInfoDao.insertSalesSubInfo(infoDTO);
        }

        XsMain xsMain = new XsMain();
        xsMain.setXssjdm(xsInfoVO.getXssjdm());
        xsMain.setXssjmc(xsInfoVO.getXssjmc());
        // 销售商品编码
        xsMain.setXsdm(datetime + increase);
        xsMain.setXszje(totalAmount);
        xsMain.setXszzl(totalWeight);
        xsMain.setXspaydm(xsInfoVO.getXspaydm());
        xsMain.setXspaymc(xsInfoVO.getXspaymc());
        // 插入主表
        this.xsInfoDao.insertSalesMainInfo(xsMain);
        map.put("xsdm", datetime + increase);
        map.put("totalAmount", totalAmount);
        return Result.data(map);
    }

    @Override
    public Result selectXsInfo(XsMain xsMain) {
        List<XsInfoDTO> infoDTOS = this.xsInfoDao.selectXsInfo(xsMain);
        return Result.data(infoDTOS);
    }

    @Override
    @Transactional
    public Result saveAmount(XsMainInfoVO xsInfoVO) {
        if (xsInfoVO != null) {
            //           for (XsMainInfoVO infoVO : xsInfoVO) {
            // 销售总金额
            BigDecimal amount = xsInfoVO.getAmount();
            // 下家金额
            BigDecimal xsje = xsInfoDao.selectXsje(xsInfoVO.getXsxjdm());
            // 根据销售编码查询上家编码
            String xssjdm = xsInfoDao.selectXssjdmByXsdm(xsInfoVO.getXsdm());
            // 上家金额
            BigDecimal sjje = xsInfoDao.selectXsje(xssjdm);

            if (xsje.compareTo(amount) > -1) {
                xsInfoVO.setXssjdm(xssjdm);
                // 更新销售主表信息
                xsInfoDao.updateXsMainInfo(xsInfoVO);
                // 下家余额 = 下家金额 - 销售总金额
                BigDecimal xjye = xsje.subtract(amount);
                xsInfoDao.updateKhBalance(xjye,xsInfoVO.getXsxjdm());

                // 上家余额 = 上家金额 + 销售总金额
                BigDecimal sjye = sjje.add(amount);
                xsInfoDao.updateKhBalance(sjye,xssjdm);
                return Result.msg("交易成功");
            }
            return Result.msg("余额不足，交易失败！");
        }
        return Result.msg("参数为空！");
    }

    @Override
    public Result updateCheckByXsdm(XsMain xsMains) {
        this.xsInfoDao.updateCheck(xsMains);
        return Result.successMsg();
    }

    @Override
    public Result selectXsMainIfRecord(String xsrq, String xszje, String xsdm) {
        String ifRecord = this.xsInfoDao.selectXsMainIfRecord(xsrq, xszje, xsdm);
        return Result.data(ifRecord);
    }

    @Override
    public Result selectPatrolByXsSjdm(String xssjdm) {
        List<XsInfoDTO> xsInfoDTOS = this.xsInfoDao.selectPatrol(xssjdm);
        return Result.data(xsInfoDTOS);
    }

    @Override
    public Result selectVerificationCertificateByXsSjdm(String xssjdm, String xsrq) {
        List<XsInfoDTO> xsInfoDTOS = this.xsInfoDao.selectVerificationCertificate(xssjdm, xsrq);
        // 给前端拼JSON格式
        XsVerificationVO xsVerificationVO = new XsVerificationVO();
        ArrayList<XsSub> sub = new ArrayList<>();
        // 总金额
        BigDecimal totalAmount = new BigDecimal(0);
        // 总重量
        BigDecimal totalWeight = new BigDecimal(0);
        for (XsInfoDTO xsInfoDTO : xsInfoDTOS) {
            XsSub xsSub = new XsSub();
            xsSub.setXsspmc(xsInfoDTO.getXsspmc());
            xsSub.setXsdj(xsInfoDTO.getXsdj());
            xsSub.setXszje(xsInfoDTO.getXszje());
            BigDecimal xszje = xsInfoDTO.getXszje();
            xsSub.setXszzl(xsInfoDTO.getXszzl());
            BigDecimal xszzl = xsInfoDTO.getXszzl();
            totalAmount = xszje.add(totalAmount);
            totalWeight = xszzl.add(totalWeight);
            sub.add(xsSub);

            xsVerificationVO.setXsSub(sub);
            xsVerificationVO.setXsrq(xsInfoDTO.getXsrq());
            xsVerificationVO.setXsxjmc(xsInfoDTO.getXsxjmc());
        }
        xsVerificationVO.setXszzl(totalWeight);
        xsVerificationVO.setXszje(totalAmount);
        ArrayList<XsVerificationVO> list = new ArrayList<>();
        list.add(xsVerificationVO);
        return Result.data(list);
    }

}
