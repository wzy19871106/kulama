package cn.shianxian.supervise.tibetan.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Table(name = "qzgy_jh_sub")
public class JhSub {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    @Size(message = "主键过长！", max = 11)
    private Long id;

    /**
     * 进货批次号
     */
    @Column(name = "jh_dm")
    @Size(message = "进货批次号过长！", max =20)
    private String jhdm;

    /**
     * 进货商品代码
     */
    @Column(name = "jh_spdm")
    @Size(message = "进货商品代码过长！", max = 8)
    private String jhspdm;

    /**
     * 进货商品名称
     */
    @Column(name = "jh_spmc")
    @Size(message = "进货商品名称过长！", max = 30)
    private String jhspmc;

    /**
     * 进货重量
     */
    @Column(name = "jh_zl")
    private BigDecimal jhzl;

    /**
     * 进货数量
     */
    @Column(name = "jh_sl")
    private BigDecimal jhsl;

    /**
     * 进货金额
     */
    @Column(name = "jh_je")
    private BigDecimal jhje;

    /**
     * 批次顺序号
     */
    @Column(name = "jh_index")
    @Size(message = "批次顺序号过长！", max = 11)
    private Long jhindex;
}
