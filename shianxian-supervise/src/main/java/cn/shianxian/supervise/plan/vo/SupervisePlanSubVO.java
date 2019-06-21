package cn.shianxian.supervise.plan.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 计划任务子表
 */
@Data
public class SupervisePlanSubVO {


    /**
     * 企业编码
     */
    private String nodeTag;

    /**
     * 企业名称
     */
    private String nodeName;

    /**
     * 计划检查时间
     */
    private LocalDateTime superviseTime;

    /**
     * 监管类型id
     */
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

}
