package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface XsInfoDao {

    /**
     * 插入销售主表信息
     */
    String insertSalesMainInfo(XsInfoVO xsInfoVO);

    /**
     * 插入销售从表信息
     * @param xsInfoVO
     * @return
     */
    String insertSalesSubInfo(XsInfoVO xsInfoVO);

    /**
     * 根据销售编码查询余额
     * @param xsxjmc
     * @return
     */
    BigDecimal selectXsje(String xsxjmc);

    /**
     * 根据下家编码查询
     * @param xssjdm
     * @param xsxjdm
     * @param xschecked
     * @return
     */
    XsInfoDTO selectXsInfo(@Param("xssjdm") String xssjdm, @Param("xsxjdm") String xsxjdm, @Param("xschecked") String xschecked);

    /**
     * 更新销售信息
     * @param xsInfoVO
     * @return
     */
    String updateXsMainInfo(XsMainInfoVO xsInfoVO);

    /**
     * 根据下家编码更新下家余额
     * @param balance
     * @return
     */
    String updateXjBalance(BigDecimal balance,String xsxjdm);
}
