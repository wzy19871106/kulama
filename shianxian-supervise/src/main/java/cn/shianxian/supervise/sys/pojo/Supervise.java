package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 监管内容
 */
@Data
@Table(name = "t_supervise")
public class Supervise {


    /**
     * 监管项目编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "superviseTag")
    private String superviseTag;

    /**
     * 父内容编码
     */
    @Column(name = "parentTag")
    private String parentTag;

    /**
     * 监管类型编码
     */
    @Column(name = "superviseTypeTag")
    private String superviseTypeTag;

    /**
     * 检查内容
     */
    @Column(name = "superviseName")
    private String superviseName;

    /**
     * 检查依据
     */
    @Column(name = "superviseBasis")
    private String superviseBasis;

    /**
     * 检查方式
     */
    @Column(name = "superviseMode")
    private String superviseMode;

    /**
     * 检查指南
     */
    @Column(name = "superviseGuide")
    private String superviseGuide;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 模块位置，4位以上数字
     */
    @Column(name = "`order`")
    private String order;

    /**
     * 监管项目分值
     */
    @Column(name = "score")
    private Double score;

    /**
     * 是否可以添加监管结果信息
     */
    @Column(name = "ifMenu")
    private String ifMenu;

    /**
     * 栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询
     */
    @Column(name = "ifUse")
    private String ifUse;

    /**
     * 栏目禁用，不可添加新信息，历史数据不可查(逻辑删除)
     */
    @Column(name = "ifDelete")
    private String ifDelete;

}
