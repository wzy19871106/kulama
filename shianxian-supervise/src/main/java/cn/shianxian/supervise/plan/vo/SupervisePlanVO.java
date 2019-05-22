package cn.shianxian.supervise.plan.vo;

import lombok.Data;

@Data
public class SupervisePlanVO {


    /**
     * 监管业务(主类型)主键
     */
    private String mainIds;

    /**
     * 监管日期
     */
    private String createTime;

    /**
     * 计划任务编号（非计划任务监管可为空)
     */
    private String planTag;


    /**
     * 计划任务名称
     */
    private String planName;

    /**
     * 监管类型id
     */
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 监管内容id
     */
    private String superviseTag;

    /**
     * 监管内容名称
     */
    private String superviseName;
}
