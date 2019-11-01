package cn.shianxian.supervise.tibetan.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class XsInfoDTO {
    /**
     * 销售日期
     */
    private String xsrq;

    /**
     *销售上家编码
     */
    private String xssjdm;

    /**
     *销售上家名称
     */
    private String xssjmc;

    /**
     *销售下家编码
     */
    private String xsxjdm;

    /**
     *销售下家名称
     */
    private String xsxjmc;

    /**
     *销售批次号
     */
    private String xsdm;

    /**
     * 记录状态（1正常 2删除）
     */
    private String xsued;

    /**
     *上家巡视状态（1 已巡视 0未巡视）
     */
    private String xschecksj;

    /**
     * 下家巡视状态（1 已巡视 0未巡视）
     */
    private String xscheckxj;

    /**
     *巡视意见
     */
    private String xscheckmark;

    /**
     *巡查员编码
     */
    private String xscheckdm;

    /**
     *巡查员名称
     */
    private String xscheckmc;

    /**
     *商品编码
     */
    private String xsspdm;

    /**
     *商品名称
     */
    private String xsspmc;

    /**
     *重量
     */
    private BigDecimal xszl;

    /**
     *单价
     */
    private BigDecimal xsdj;

    /**
     *金额
     */
    private BigDecimal xsje;

    /**
     *批次顺序号
     */
    private Long xsindex;

    /**
     *进货批次号
     */
    private String jhdm;

    /**
     *支付方式编码
     */
    private String xspaydm;

    /**
     *支付方式名称
     */
    private String xspaymc;

    /**
     *总金额
     */
    private BigDecimal zje;

    /**
     *总重量
     */
    private BigDecimal zzl;

    /**
     *销售总金额
     */
    private BigDecimal xszje;

    /**
     *销售总重量
     */
    private BigDecimal xszzl;

    /**
     * 库存
     */
    private BigDecimal repertory;

    /**
     * 商品名称
     */
    private String spmc;
}
