package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 监管业务主表
 */
@Data
@Table(name = "t_Supervise_Info_Main")
public class SuperviseInfoMain {


    /**
     * 监管业务主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "mainId")
    @Size(message = "监管业务主键过长！", max = 50)
    private String mainId;

    /**
     * 计划任务编号（非计划任务监管可为空)
     */
    @Column(name = "planTag")
    @Size(message = "计划任务编号过长！", max = 11)
    private Long planTag;

    /**
     * 企业类型
     */
    @Column(name = "nodeType")
    @Size(message = "企业类型过长！", max = 4)
    private String nodeType;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    @Size(message = "企业编码过长！", max = 60)
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    @Size(message = "企业名称过长！", max = 100)
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
    @Size(message = "备注过长！", max = 100)
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

    /**
     * 监管类型集合
     */
    @Transient
    List<SuperviseInfoMainType> superviseInfoMainTypes;

}
