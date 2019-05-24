package cn.shianxian.supervise.info.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 线下监管业务从表
 */
@Data
@Table(name = "t_SuperviseInfoSubOld")
public class SuperviseInfoSubOld {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "subId")
    private Long subId;

    /**
     * 主表外键
     */
    @Column(name = "mainId")
    private String mainId;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    private String nodeTag;

    /**
     * 监管类型编码
     */
    @Column(name = "superviseTypeTag")
    private String superviseTypeTag;

    /**
     * 监管项目编码
     */
    @Column(name = "superviseTag")
    private String superviseTag;

    /**
     * 监管内容详细
     */
    @Column(name = "superviseName")
    private String superviseName;

    /**
     * 监管结果编码
     */
    @Column(name = "resultTag")
    private String resultTag;

    /**
     * 监管结果值
     */
    @Column(name = "resultValue")
    private String resultValue;

    /**
     * 结果分值
     */
    @Column(name = "score")
    private Long score;

    /**
     * 整改意见
     */
    @Column(name = "advice")
    private String advice;

    /**
     * 整改反馈
     */
    @Column(name = "requst")
    private String requst;

    /**
     * 整改反馈附件
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 整改状态  0 无需整改 1，整改完成 2，待整改，3 整改提交，待审核4……
     */
    @Column(name = "status")
    private String status;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
