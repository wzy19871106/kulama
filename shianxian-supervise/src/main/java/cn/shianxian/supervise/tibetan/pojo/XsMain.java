package cn.shianxian.supervise.tibetan.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Table(name = "qzgy_xs_main")
public class XsMain {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    @Size(message = "主键过长！", max = 11)
    private Long id;

    /**
     * 销售日期
     */
    @Column(name = "xs_rq")
    private String xsrq;

    /**
     * 上家编码
     */
    @Column(name = "xs_sjdm")
    @Size(message = "上家编码过长！",max =13 )
    private String xssjdm;

    /**
     * 上家名称
     */
    @Column(name = "xs_sjmc")
    @Size(message = "上家名称过长！",max =200 )
    private String xssjmc;

    /**
     * 下家编码
     */
    @Column(name = "xs_xjdm")
    @Size(message = "下家编码过长！",max =13 )
    private String xsxjdm;

    /**
     * 下家名称
     */
    @Column(name = "xs_xjmc")
    @Size(message = "下家名称过长！",max =200 )
    private String xsxjmc;


    /**
     * 销售批次号
     */
    @Column(name = "xs_dm")
    @Size(message = "销售批次号过长！",max =25 )
    private String xsdm;

    /**
     * 销售总金额
     */
    @Column(name = "xs_zje")
    private BigDecimal xszje;

    /**
     * 销售总重量
     */
    @Column(name = "xs_zzl")
    private BigDecimal xszzl;

    /**
     * 记录状态（1正常 2删除）
     */
    @Column(name = "xs_used")
    @Size(message = "记录状态过长！",max =1 )
    private String xsused;

    /**
     * 巡视状态（1 已巡视 0未巡视）
     */
    @Column(name = "xs_checked")
    @Size(message = "巡视状态过长！",max =1 )
    private String xschecked;

    /**
     * 巡视意见
     */
    @Column(name = "xs_checkmark")
    @Size(message = "巡视意见过长！",max =200 )
    private String xscheckmark;

    /**
     * 巡查员编码
     */
    @Column(name = "xs_checkdm")
    @Size(message = "巡查员编码过长！",max =13 )
    private String xscheckdm;

    /**
     * 巡查员名称
     */
    @Column(name = "xs_checkmc")
    @Size(message = "巡查员名称过长！",max =200 )
    private String xscheckmc;

    /**
     * 支付方式编码（1现金 2 银行卡 3 记账）
     */
    @Column(name = "xs_paydm")
    @Size(message = "支付方式编码过长！",max = 1)
    private String xspaydm;

    /**
     * 支付方式名称
     */
    @Column(name = "xs_paymc")
    @Size(message = "支付方式名称过长！",max = 20)
    private String xspaymc;
}
