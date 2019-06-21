package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 企业负责人审核表
 */
@Table(name = "t_FunctionaryForaduit")
@Data
public class FunctionaryForaduit {

    /**
     * 所属企业标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "nodeTag")
    @NotEmpty(message = "企业标识不可为空！")
    @Size(message = "企业标识过长！", max = 50)
    private String nodeTag;

    /**
     * 负责人标识
     */
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
     * 负责人图片地址标识
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
     * 审核状态:1新增，2删除，3变更，4审核失败，5注销，6注销通过，0已完成
     */
    @Column(name = "aduitType")
    @Size(message = "审核状态过长！", max = 1)
    private String aduitType;

    /**
     * 注销时间
     */
    @Column(name = "updateTime")
    private LocalDateTime updateTime;

    /**
     * 退回说明
     */
    @Column(name = "failReason")
    @Size(message = "退回说明过长！", max = 200)
    private String failReason;

    /**
     * 激活KEY
     */
    @Column(name = "`key`")
    @Size(message = "激活KEY过长！", max = 20)
    private String key;

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

}
