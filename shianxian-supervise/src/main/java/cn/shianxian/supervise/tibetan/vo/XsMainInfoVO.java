package cn.shianxian.supervise.tibetan.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class XsMainInfoVO {

    /**
     * 下家编码
     */
    private String xsxjdm;

    /**
     * 下家名称
     */
    private String xsxjmc;

    /**
     * 支付方式编码
     */
    private String xspaydm;

    /**
     * 支付方式
     */
    private String xspaymc;

    /**
     * 销售编码
     */
    private String xsdm;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 记录状态（1正常 2删除）
     */
    private String xsused = "1";

//    /**
//     * 上家编码
//     */
//    private String xssjdm;
}
