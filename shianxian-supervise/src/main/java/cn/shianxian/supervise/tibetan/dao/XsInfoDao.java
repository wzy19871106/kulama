package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface XsInfoDao {

    /**
     * 插入销售主表信息
     */
    String insertSalesMainInfo(XsMain xsMain);

    /**
     * 插入销售从表信息
     *
     * @param xsInfoVO
     * @return
     */
    String insertSalesSubInfo(XsInfoVO xsInfoVO);

    /**
     * 根据销售编码查询余额
     *
     * @param xsxjdm
     * @return
     */
    BigDecimal selectXsje(String xsxjdm);

    /**
     * 根据各种条件查询销售信息
     *
     * @return
     */
    List<XsInfoDTO> selectXsInfo(XsMain xsMain);

    /**
     * 更新销售信息
     *
     * @param xsInfoVO
     * @return
     */
    int updateXsMainInfo(XsMainInfoVO xsInfoVO);

    /**
     * 根据客户编码更新客户余额
     *
     * @param balance
     * @return
     */
    int updateKhBalance(BigDecimal balance, String dm);

    /**
     * 根据销售上下家编码修改巡视意见
     *
     * @param xsMains
     * @return
     */
    String updateCheck(XsMain xsMains);

    /**
     * 根据销售编码查询上家编码
     * @param xsdm
     * @return
     */
    String selectXssjdmByXsdm(String xsdm);

    /**
     * 根据销售编码查询是否有记录
     * @param xsrq
     * @param xszje
     * @param xsdm
     * @return
     */
    String selectXsMainIfRecord(String xsrq,String xszje,String xsdm);

    /**
     * 上家 卖家 巡查
     * @param xssjdm
     * @return
     */
    List<XsInfoDTO> selectPatrol(String xssjdm);

    /**
     * 下家 买家 验单
     * @param xssjdm
     * @return
     */
    List<XsInfoDTO> selectVerificationCertificate(String xssjdm,String xsrq);
}
