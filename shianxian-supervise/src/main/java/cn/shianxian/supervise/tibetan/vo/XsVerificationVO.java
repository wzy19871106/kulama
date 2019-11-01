package cn.shianxian.supervise.tibetan.vo;

import cn.shianxian.supervise.tibetan.pojo.XsSub;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class XsVerificationVO {

    /**
     * 销售清单
     */
    private List<XsSub> xsSub;

    /***
     * 销售总重量
     */
    private BigDecimal xszzl;

    /**
     * 销售总金额
     */
    private BigDecimal xszje;

    /**
     * 销售下家名称
     */
    private String xsxjmc;

    /**
     * 销售日期
     */
    private String xsrq;
}
