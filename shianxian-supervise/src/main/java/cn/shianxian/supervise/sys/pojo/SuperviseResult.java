package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * 监管结果
 */
@Data
@Table(name = "t_supervise_result")
public class SuperviseResult {


    /**
     * 监管结果编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "resultTag")
    @NotEmpty(message = "编码不能为空！")
    private String resultTag;

    /**
     * 监管内容编码（外）
     */
    @Column(name = "superviseTag")
    private String superviseTag;

    /**
     * 监管结果
     */
    @Column(name = "resultValue")
    private String resultValue;

    /**
     * 排序
     */
    @Column(name = "`order`")
    private String order;

    /**
     * 结果分值
     */
    @Column(name = "score")
    private Double score;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 整改意见,该结果单项的整改意见
     */
    @Column(name = "advice")
    private String advice;

    /**
     * 是否启用
     */
    @Column(name = "ifUse")
    private Boolean ifUse;

    /**
     * 是否删除
     */
    @Column(name = "ifDelete")
    private Boolean ifDelete;

    /**
     * 监管类型id
     */
    @Transient
    private String superviseTypeTag;

}
