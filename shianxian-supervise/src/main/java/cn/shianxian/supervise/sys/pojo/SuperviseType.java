package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private Boolean ifMenu;

    /**
     * 栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询
     */
    @Column(name = "ifUse")
    private Boolean ifUse;

    /**
     * 栏目禁用，不可添加新信息，历史数据不可查
     */
    @Column(name = "ifDelete")
    private Boolean ifDelete;

    /**
     * 父类型名称
     */
    @Transient
    private String parentName;

    /**
     * 监管内容集合
     */
    @Transient
    private List<Supervise> superviseList;

    /**
     * 监管子内容集合数量
     */
    @Transient
    private int num;

    /**
     * 计划任务id
     */
    @Transient
    private Long planTag;

    /**
     * 企业id
     */
    @Transient
    private String nodeTag;

    /**
     * 企业名称
     */
    @Transient
    private String nodeName;

    /**
     * 执法队伍id
     */
    @Transient
    private String superviseTeamTag;

    /**
     * 执法队伍名称
     */
    @Transient
    private String superviseTeamName;

    /**
     * 执法人id
     */
    @Transient
    private String superviserTag;

    /**
     * 执法人名称
     */
    @Transient
    private String superviserName;


    /**
     * 负责人id
     */
    @Transient
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Transient
    private String functionaryName;

}
