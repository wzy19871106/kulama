package cn.shianxian.supervise.tibetan.vo;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class XsInfoVO {

    /**
     * 销售商品编码
     */
    private String xsspdm;

    /**
     * 销售日期
     */
    private String xsrq;

    /**
     * 销售商品名称
     */
    private String xsspmc;

    /**
     * 销售重量
     */
    private BigDecimal xszl;

    /**
     * 销售单价
     */
    private BigDecimal xsdj;

    /**
     * 销售金额
     */
    private BigDecimal xsje;

    /**
     * 上家编码
     */
    private String xssjdm;

    /**
     * 上家名称
     */
    private String xssjmc;

    /**
     * 下家名称
     */
    private String xsxjmc;

    /**
     * 下家编码
     */
    private String xsxjdm;

    /**
     * 进货批次号
     */
    private String jhdm;

    /**
     * 记录状态（1正常 2删除）
     */
    private String xsused = "0";

    /**
     * 上家巡视状态（1 已巡视 0未巡视）
     */
    private String xschecksj = "0";

    /**
     * 下家巡视状态（1 已巡视 0未巡视）
     */
    private String xscheckxj = "0";

    /**
     * 支付方式编码（1现金 2 银行卡 3 记账）
     */
    private String xspaydm;

    /**
     * 支付方式名称
     */
    private String xspaymc;

    /**
     *排列序号
     */
    private String jhindex;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 销售编码
     */
    private String xsdm;

    /**
     * 销售总金额
     */
    private BigDecimal xszje;

    /**
     * 销售总重量
     */
    private BigDecimal xszzl;

    /**
     * 巡视意见
     */
    private String xscheckmark;

    /**
     * 巡查人员编码
     */
    private String xscheckdm;

    /**
     * 巡查人员名称
     */
    private String xscheckmc;

    /**
     * 批次顺序号
     */
    private String xsindex;


}
