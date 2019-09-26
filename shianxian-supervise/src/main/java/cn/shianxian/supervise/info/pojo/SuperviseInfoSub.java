package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 监管业务从表
 */
@Data
@Table(name = "t_Supervise_Info_Sub")
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
    @Size(message = "监管业务主类型编码过长！", max = 50)
    private String mainIds;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    @Size(message = "企业编码过长！", max = 60)
    private String nodeTag;

    /**
     * 监管类型编码
     */
    @Column(name = "superviseTypeTag")
    @Size(message = "监管类型编码过长！", max = 50)
    private String superviseTypeTag;

    /**
     * 监管内容编码
     */
    @Column(name = "superviseTag")
    @Size(message = "监管内容编码过长！", max = 50)
    private String superviseTag;

    /**
     * 监管内容名称
     */
    @Column(name = "superviseName")
    @Size(message = "监管内容名称过长！", max = 100)
    private String superviseName;

    /**
     * 监管结果编码
     */
    @Column(name = "resultTag")
    @Size(message = "监管结果编码过长！", max = 50)
    private String resultTag;

    /**
     * 监管结果值
     */
    @Column(name = "resultValue")
    @Size(message = "监管结果过长！", max = 50)
    private String resultValue;

    /**
     * 结果分值
     */
    @Column(name = "score")
    private Double score;

    /**
     * 整改意见
     */
    @Column(name = "advice")
    @Size(message = "整改意见过长！", max = 200)
    private String advice;

    /**
     * 整改反馈
     */
    @Column(name = "requst")
    @Size(message = "整改反馈过长！", max = 200)
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
    @Size(message = "创建人过长！", max = 50)
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
    @Size(message = "最后更新人过长！", max = 50)
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
    @Size(message = "备注过长！", max = 100)
    private String remark;

    /**
     * 监管业务外键
     */
    @Transient
    private String mainId;

    /**
     * 企业名称
     */
    @Transient
    private String nodeName;

    /**
     * 截图取证
     */
    @Transient
    private String screenshot;

    /**
     * 反馈
     */
    @Transient
    private String feedback;

}
