package cn.shianxian.supervise.tibetan.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class XsInfoDTO {

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
     * 进货批次号
     */
    private String jhdm;

    /**
     * 记录状态（1正常 2删除）
     */
    private String xsused = "0";

    /**
     * 巡视状态（1 已巡视 0未巡视）
     */
    private String xschecked = "0";

    /**
     * 支付方式编码（1现金 2 银行卡 3 记账）
     */
    private String xspaydm;

    /**
     * 支付方式名称
     */
    private String xspaymc;




}
