package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessRadarActualAreaScoreVO {

    /**
     * 备案完整率
     */
    private Double backupCompletelyRate;

    /**
     * 规范经营情况
     */
    private Double regulatedManagementRate;

    /**
     * 及时整改率
     */
    private Double timelyCorrectiveRate;

    /**
     * 问题复现率
     */
    private Double repetitionProblemRate;

    /**
     * 整改完成率
     */
    private Double correctiveCompletelyRate;

    /**
     * 呼叫响应及时情况
     */
    private Double timelyResponseRate;

    /**
     * 计划任务完成率
     */
    private Double planTaskCompletelyRate;

    /**
     * 巡查数据完整性
     */
    private Double patrolDataCompletionRate;

    /**
     * 数据增长率
     */
    private Double dataIncreaseRate;

    /**
     * 情况及时反馈率
     */
    private Double timelyFeedbackRate;

    /**
     * 巡查次数达标率
     */
    private Double patrolTimesRate;


}
