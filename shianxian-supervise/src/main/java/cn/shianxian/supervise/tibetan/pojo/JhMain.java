package cn.shianxian.supervise.tibetan.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Table(name = "qzgy_jh_main")
public class JhMain {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    @Size(message = "主键过长！", max = 11)
    private Long id;

    /**
     * 产地证号
     */
    @Column(name = "jh_cdzh")
    @Size(message = "产地证号过长！",max =20 )
    private String cdzh;

    /**
     * 进货日期
     */
    @Column(name = "jh_rq")
    private String rq;

    /**
     * 进货批次号
     */
    @Column(name = "jh_dm")
    @Size(message = "进货批次号过长！",max =20 )
    private String dm;

    /**
     * 进货总重量
     */
    @Column(name = "jh_zzl")
    private BigDecimal zzl;

    /**
     * 进货总数量
     */
    @Column(name = "jh_zsl")
    private BigDecimal zsl;

    /**
     * 记录状态（1正常 2删除）
     */
    @Column(name = "jh_used")
    @Size(message = "记录状态过长！",max =1 )
    private String used;

    /**
     * 进货客户编码
     */
    @Column(name = "jh_kh_dm")
    @Size(message = "进货客户编码过长！",max =13 )
    private String jhkhdm;

    /**
     * 进货客户名称
     */
    @Column(name = "jh_kh_mc")
    @Size(message = "进货客户名称过长！",max =200 )
    private String jhkhmc;



}
