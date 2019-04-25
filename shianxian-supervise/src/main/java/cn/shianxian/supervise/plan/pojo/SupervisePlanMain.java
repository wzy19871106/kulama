package cn.shianxian.supervise.plan.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 计划任务主表
 */
@Data
@Table(name = "t_superviseplan_main")
public class SupervisePlanMain {


    /**
     * 计划任务编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`PlanTag`")
    private String planTag;

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
     * 创建日期
     */
    @Column(name = "`createTime`")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "`createUserTag`")
    private String createUserTag;

    /**
     * 最后更新日期
     */
    @Column(name = "`lastUpdateTime`")
    private LocalDateTime lastUpdateTime;

    /**
     * 最后更新人
     */
    @Column(name = "`lastUpdateUser`")
    private String lastUpdateUser;

    /**
     * 逻辑删除
     */
    @Column(name = "`ifDelete`")
    private Boolean ifDelete;

}
