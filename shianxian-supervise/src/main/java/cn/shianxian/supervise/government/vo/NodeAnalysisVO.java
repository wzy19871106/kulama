package cn.shianxian.supervise.government.vo;

import lombok.Data;

@Data
public class NodeAnalysisVO {


    /**
     * 节点标识
     */
    private String nodeTag;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 监管次数
     */
    private Long superviseTimes;

    /**
     * 监管类型个数
     */
    private Long superviseTypeNum;

    /**
     * 需要整改的状态
     */
    private Long completeStatus;

    /**
     * 所有的状态
     */
    private Long allStatus;

    /**
     * 平均分数
     */
    private Double avgScore;

    /**
     * 级别
     */
    private String scoreLevel;

    /**
     * 总分数
     */
    private Double score;
}
