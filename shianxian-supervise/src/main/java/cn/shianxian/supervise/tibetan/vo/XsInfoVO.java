package cn.shianxian.supervise.tibetan.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class XsInfoVO {
    /**
     * 销售日期
     */
    private String xs_rq;

    /**
     *销售上家编码
     */
    private String xs_sjdm;

    /**
     *销售上家名称
     */
    private String xs_sjmc;

    /**
     *销售下家编码
     */
    private String xs_xjdm;

    /**
     *销售下家名称
     */
    private String xs_xjmc;

    /**
     *销售批次号
     */
    private String xs_dm;

    /**
     *巡视状态
     */
    private String xs_checked;

    /**
     *巡视意见
     */
    private String xs_check_mark;

    /**
     *巡查员编码
     */
    private String xs_checkdm;

    /**
     *巡查员名称
     */
    private String xs_checkmc;

    /**
     *商品编码
     */
    private String xs_spdm;

    /**
     *商品名称
     */
    private String xs_spmc;

    /**
     *重量
     */
    private BigDecimal xs_zl;

    /**
     *单价
     */
    private BigDecimal xs_dj;

    /**
     *金额
     */
    private BigDecimal xs_je;

    /**
     *批次顺序号
     */
    private Long xs_index;

    /**
     *进货批次号
     */
    private String jh_dm;

    /**
     *支付方式编码
     */
    private String xs_paydm;

    /**
     *支付方式名称
     */
    private String xs_paymc;

    /**
     *总金额
     */
    private BigDecimal zje;

    /**
     *总重量
     */
    private BigDecimal zzl;

}
