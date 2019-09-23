package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.time.LocalDateTime;

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
     * 监管业务主表主键
     */
    private String mainId;

    /**
     * 监管业务(从类型)主键
     */
    private String subId;

    /**
     * 监管日期
     */
    private LocalDateTime createTime;

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
    private String resultTag;

    /**
     * 监管结果
     */
    private String resultValue;

    /**
     * 监管父内容名称
     */
    private String parentSuperviseName;

    /**
     * 节点id
     */
    private String nodeTag;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 负责人名称
     */
    private String functionaryName;

    /**
     * 监管队伍名称
     */
    private String superviseTeamName;

    /**
     * 监管队伍人员名称
     */
    private String superviserName;

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

    /**
     * 监管业务得分
     */
    private String subSuperviseScore;

    /**
     * 监管业务总分
     */
    private String subSuperviseScoreValue;

    /**
     * 监管结果得分
     */
    private String parentSuperviseScore;

    /**
     * 监管结果总分
     */
    private String parentSuperviseScoreValue;

    /**
     * 监管类型得分
     */
    private String superviseTypeScore;

    /**
     * 监管类型总分
     */
    private String superviseTypeScoreValue;

    /**
     * 整改截图
     */
    private String picTag;
}
