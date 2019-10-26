package cn.shianxian.supervise.tibetan.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Table(name = "qzgy_xs_sub")
public class XsSub {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    @Size(message = "主键过长！", max = 11)
    private Long id;

    /**
     * 销售批次号
     */
    @Column(name = "xs_dm")
    @Size(message = "销售批次号", max = 25)
    private String xsdm;

    /**
     * 销售商品编码
     */
    @Column(name = "xs_spdm")
    @Size(message = "销售商品编码", max = 8)
    private String xsspdm;

    /**
     * 销售商品名称
     */
    @Column(name = "xs_spmc")
    @Size(message = "销售商品名称", max = 30)
    private String xsspmc;

    /**
     * 销售重量
     */
    @Column(name = "xs_zl" )
    private BigDecimal xszl;

    /**
     * 销售单价
     */
    @Column(name = "xs_dj")
    private BigDecimal xsdj;

    /**
     * 销售金额
     */
    @Column(name = "xs_je")
    private BigDecimal xsje;

    /**
     * 批次顺序号
     */
    @Column(name = "xs_index")
    @Size(message = "批次顺序号", max = 11)
    private Long xsindex;

    /**
     * 进货批次号
     */
    @Column(name = "jh_dm")
    @Size(message = "进货批次号", max = 20)
    private String jhdm;

    @Transient
    private String jhindex;

    @Transient
    private String xspaydm;

    @Transient
    private String xspaymc;
}
