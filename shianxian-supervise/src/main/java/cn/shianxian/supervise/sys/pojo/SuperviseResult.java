package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @Size(message = "监管结果编码过长！", max = 50)
    private String resultTag;

    /**
     * 监管内容编码（外）
     */
    @Column(name = "superviseTag")
    @Size(message = "监管内容编码过长！", max = 50)
    private String superviseTag;

    /**
     * 监管结果
     */
    @Column(name = "resultValue")
    @Size(message = "监管结果过长！", max = 200)
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
    @Size(message = "监管结果过长！", max = 2000)
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

    /**
     * 监管内容
     */
    @Transient
    private String superviseName;

}
