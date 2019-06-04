package cn.shianxian.supervise.plan.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 计划任务主表
 */
@Data
@Table(name = "t_superviseplan_main")
public class SupervisePlanMain extends BasePojo {


    /**
     * 计划任务编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`PlanTag`")
    private Long planTag;

    /**
     * 计划任务名称
     */
    @Column(name = "`planName`")
    private String planName;

    /**
     * 开始时间
     */
    @Column(name = "`startTime`")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "`endTime`")
    private LocalDateTime endTime;

    /**
     * 是否公开
     */
    @Column(name = "`ifPulic`")
    private Boolean ifPulic;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 逻辑删除
     */
    @Column(name = "`ifDelete`")
    private Boolean ifDelete;

    /**
     * 完成比例
     */
    @Transient
    private Boolean completionRate;

}
