package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
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
     * 根据销售下家编码查询总金额
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
    XsInfoDTO selectXsInfo(String xssjdm, String xsxjdm, String xschecked);

}
