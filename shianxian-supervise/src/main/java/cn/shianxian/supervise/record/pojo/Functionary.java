package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * 企业负责人表
 */
@Table(name = "t_Functionary")
@Data
public class Functionary {

    /**
     * 所属企业标识
     */
    @Column(name = "nodeTag")
    @NotEmpty(message = "企业标识不能为空！")
    @Size(message = "企业标识过长！", max = 50)
    private String nodeTag;

    /**
     * 负责人标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "functionaryTag")
    @Size(message = "负责人标识过长！", max = 50)
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Column(name = "functionaryName")
    @Size(message = "负责人名称过长！", max = 200)
    private String functionaryName;

    /**
     * 负责人身份证号
     */
    @Column(name = "functionaryNo")
    @Size(message = "负责人身份证号过长！", max = 50)
    private String functionaryNo;

    /**
     * 负责人类型，1管理，2普通
     */
    @Column(name = "functionaryType")
    @Size(message = "负责人类型过长！", max = 200)
    private String functionaryType;

    /**
     * 企业图片地址标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 节点流水号
     */
    @Column(name = "`index`")
    private Long index;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 负责人是否启用
     */
    @Column(name = "functionaryDisable")
    private String functionaryDisable;

    /**
     * 激活KEY
     */
    @Column(name = "`key`")
    @Size(message = "激活KEY过长！", max = 20)
    private String key;

    /**
     * 是否已经激活
     */
    @Column(name = "keyUsed")
    private Integer keyUsed;

    /**
     * 所属企业名称
     */
    @Column(name = "nodeName")
    @Size(message = "企业名称过长！", max = 200)
    private String nodeName;

    /**
     * 负责人职位，无固定
     */
    @Column(name = "functionaryPostition")
    @Size(message = "负责人职位过长！", max = 200)
    private String functionaryPostition;

    /**
     * 微信AppID
     */
    @Column(name = "weChatId")
    @Size(message = "微信AppID过长！", max = 200)
    private String weChatId;

    /**
     * 人脸识别id
     */
    @Column(name = "faceTag")
    @Max(message = "人脸识别id过长！", value = Long.MAX_VALUE)
    private Long faceTag;

    /**
     * token
     */
    @Transient
    private String token;
}
