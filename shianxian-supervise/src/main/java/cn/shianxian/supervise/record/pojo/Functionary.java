package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
