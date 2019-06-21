package cn.shianxian.supervise.plan.pojo;

import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 计划任务子表
 */
@Data
@Table(name = "t_superviseplan_sub")
public class SupervisePlanSub extends BasePojo {


    /**
     * 自增编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`ids`")
    private Long ids;

    /**
     * 主任务编号
     */
    @Column(name = "`planTag`")
    @Size(message = "主任务编号过长！", max = 11)
    private String planTag;

    /**
     * 计划监管类型(多个用半角逗号隔开）
     */
    @Column(name = "`superviseTypeTag`")
    @Size(message = "计划监管类型过长！", max = 1000)
    private String superviseTypeTag;

    /**
     * 监管时间
     */
    @Column(name = "`superviseTime`")
    private LocalDateTime superviseTime;

    /**
     * 企业编码
     */
    @Column(name = "`nodeTag`")
    @Size(message = "企业编码过长！", max = 60)
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "`nodeName`")
    @Size(message = "企业名称过长！", max = 100)
    private String nodeName;

    /**
     * 执法队伍编码
     */
    @Column(name = "`superviseTeamTag`")
    @Size(message = "执法队伍编码过长！", max = 60)
    private String superviseTeamTag;

    /**
     * 执法队伍名称
     */
    @Column(name = "`superviseTeamName`")
    @Size(message = "执法队伍名称过长！", max = 100)
    private String superviseTeamName;

    /**
     * 完成情况
     */
    @Column(name = "`ifDone`")
    private Boolean ifDone;

    /**
     * 逻辑删除
     */
    @Column(name = "`ifDelete`")
    private Boolean ifDelete;

    /**
     * 主任务名称
     */
    @Transient
    private String planName;
}
