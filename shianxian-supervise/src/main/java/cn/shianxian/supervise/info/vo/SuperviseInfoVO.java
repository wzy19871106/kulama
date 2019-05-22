package cn.shianxian.supervise.info.vo;

import lombok.Data;

/**
 * 监管结果VO
 */
@Data
public class SuperviseInfoVO {


    /**
     * 监管业务(主类型)主键
     */
    private String mainIds;

    /**
     * 监管业务(从类型)主键
     */
    private String subId;

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

    /**
     * 监管结果id
     */
    private String ResultTag;

    /**
     * 监管结果
     */
    private String resultValue;

    /**
     * 监管父内容名称
     */
    private String parentSuperviseName;

    /**
     * 分数
     */
    private String score;

    /**
     * 整改状态  0 无需整改 1,2,3,4.....需要整改的数量
     */
    private String status;

    /**
     * 需要整改的状态
     */
    private String unCompleteStatus;

    /**
     * 所有的状态
     */
    private String allStatus;

}
