package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "t_SuperviseInfoSub")
public class SuperviseInfoSub {

    /**
     * 自增编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "subId")
    private Long subId;

    /**
     * 监管业务主类型表外键
     */
    @Column(name = "mainIds")
    private String mainIds;

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
     * 创建日期
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "createUserTag")
    private String createUserTag;

    /**
     * 最后更新日期
     */
    @Column(name = "lastUpdateTime")
    private LocalDateTime lastUpdateTime;

    /**
     * 最后更新人
     */
    @Column(name = "lastUpdateUser")
    private String lastUpdateUser;

    /**
     * 整改状态  0 无需整改 1，整改完成 2，待整改，3 整改提交，待审核4
     */
    @Column(name = "status")
    private Long status;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
