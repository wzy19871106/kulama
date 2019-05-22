package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 监管业务主表
 */
@Data
@Table(name = "t_SuperviseInfoMain")
public class SuperviseInfoMain {


    /**
     * 监管业务主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "mainId")
    private String mainId;

    /**
     * 计划任务编号（非计划任务监管可为空)
     */
    @Column(name = "planTag")
    private Long planTag;

    /**
     * 企业类型
     */
    @Column(name = "nodeType")
    private String nodeType;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    private String nodeName;

    /**
     * 监管日期
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 附件路径
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 逻辑删除
     */
    @Column(name = "ifDelete")
    private String ifDelete;


}
