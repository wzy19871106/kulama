package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 监管结果
 */
@Data
@Table(name = "t_supervisetype")
public class SuperviseType {


    /**
     * 监管类型编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "superviseTypeTag")
    private String superviseTypeTag;

    /**
     * 父类型编码
     */
    @Column(name = "parentTag")
    private String parentTag;

    /**
     * 监管类型名
     */
    @Column(name = "superviseTypeName")
    private String superviseTypeName;

    /**
     * 监管类型位置
     */
    @Column(name = "`order`")
    private String order;

    /**
     * 哪些数据权限模板拥有该监管类型的数据权限
     */
    @Column(name = "userGroupDataAuthority")
    private String userGroupDataAuthority;

    /**
     * 是否可以为该栏目添加信息
     */
    @Column(name = "ifMenu")
    private Integer ifMenu;

    /**
     * 栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询
     */
    @Column(name = "ifUse")
    private Integer ifUse;

    /**
     * 栏目禁用，不可添加新信息，历史数据不可查
     */
    @Column(name = "ifDelete")
    private Integer ifDelete;

}
