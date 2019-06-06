package cn.shianxian.supervise.info.vo;

import lombok.Data;

/**
 * 整改情况分数
 */
@Data
public class RectifyStatusVO {


    /**
     * 已整改项数量
     */
    private Long changedStatus;

    /**
     * 已整改项
     */
    private Long completeStatus;

    /**
     * 未完成数量
     */
    private Long unCompleteStatus;

}
