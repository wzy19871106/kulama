package cn.shianxian.supervise.tibetan.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Table(name = "qzgy_khda")
public class Khda {

    /**
     * 自增编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    @Size(message = "自增编码过长！", max = 11)
    private Long id;

    /**
     * 客户编码
     */
    @Column(name = "kh_dm")
    @Size(message = "客户编码过长",max = 13)
    private String khdm;

    /**
     * 客户名称
     */
    @Column(name = "kh_mc")
    @Size(message = "客户名称过长",max = 200)
    private String khmc;

    /**
     * 客户简码
     */
    @Column(name = "kh_jm")
    @Size(message = "客户简码过长!",max = 6)
    private String khjm;

    /**
     * 登录用户名
     */
    @Column(name = "kh_loginname")
    @Size(message = "登录用户名过长！",max = 11)
    private String khloginname;

    /**
     * 登录密码
     */
    @Column(name = "kh_loginpass")
    @Size(message = "登录密码过长！",max = 10)
    private String khloginpass;

    /**
     * 资金余额
     */
    @Column(name = "kh_money")
    private BigDecimal khmoney;

    /**
     * 是否使用（1使用，0不使用）
     */
    @Column(name = "kh_use")
    private String khuse;

    /**
     * 1 上家  2 下家  3 巡检
     */
    @Column(name = "kh_type")
    private String khtype;
}
