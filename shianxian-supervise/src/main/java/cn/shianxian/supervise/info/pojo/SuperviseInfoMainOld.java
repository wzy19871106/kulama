package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 线下监管业务主表
 */
@Data
@Table(name = "t_SuperviseInfoMainOld")
public class SuperviseInfoMainOld {

    /**
     * 监管业务主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "mainId")
    private String mainId;

    /**
     * 监管业务父ID
     */
    @Column(name = "parentMainId")
    private String parentMainId;

    /**
     * 计划任务编号（非计划任务监管可为空)
     */
    @Column(name = "planTag")
    private Long planTag;

    /**
     * 计划任务子任务编号（非计划任务监管可为空）
     */
    @Column(name = "planIDs")
    private Long planIDs;

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
     * 执法队伍编码
     */
    @Column(name = "superviseTeamTag")
    private String superviseTeamTag;

    /**
     * 执法队伍名称
     */
    @Column(name = "superviseTeamName")
    private String superviseTeamName;

    /**
     * 执法人员编码
     */
    @Column(name = "superviserTag")
    private String superviserTag;

    /**
     * 执法人员名称
     */
    @Column(name = "superviserName")
    private String superviserName;

    /**
     * 负责人编码
     */
    @Column(name = "functionaryTag")
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Column(name = "functionaryName")
    private String functionaryName;

    /**
     * 整改状态  0 无需整改 1,2,3,4.....需要整改的数量
     */
    @Column(name = "status")
    private String status;

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
     * 回访状态
     */
    @Column(name = "ifVisit")
    private String ifVisit;

    /**
     * 逻辑删除
     */
    @Column(name = "ifDelete")
    private String ifDelete;

}
