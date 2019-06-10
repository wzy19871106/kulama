package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 整改情况时间轴
 */
@Data
public class RectifyTimeVO {

    private String id;

    /**
     * 监管业务类型id
     */
    private String mainIds;

    /**
     * 监管时间轴名称
     */
    private String roundName;

    /**
     * 监管时间
     */
    private LocalDateTime superviseTime;

    /**
     * 监管内容
     */
    private RectifyResultVO rectifyResults;

}
