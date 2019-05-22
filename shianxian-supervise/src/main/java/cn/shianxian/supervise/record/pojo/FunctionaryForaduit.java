package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String nodeTag;

    /**
     * 负责人标识
     */
    @Column(name = "functionaryTag")
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Column(name = "functionaryName")
    private String functionaryName;

    /**
     * 负责人身份证号
     */
    @Column(name = "functionaryNo")
    private String functionaryNo;

    /**
     * 负责人类型，1管理，2普通
     */
    @Column(name = "functionaryType")
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
    private String failReason;

    /**
     * 激活KEY
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 所属企业名称
     */
    @Column(name = "nodeName")
    private String nodeName;

    /**
     * 负责人职位，无固定
     */
    @Column(name = "functionaryPostition")
    private String functionaryPostition;

    /**
     * 微信AppID
     */
    @Column(name = "weChatId")
    private String weChatId;

}
