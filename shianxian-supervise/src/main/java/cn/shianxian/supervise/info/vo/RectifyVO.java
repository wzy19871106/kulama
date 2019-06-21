package cn.shianxian.supervise.info.vo;


import lombok.Data;

import java.util.List;


/**
 * 整改建议详情VO
 */
@Data
public class RectifyVO {


    /**
     * 监管业务（从表）id
     */
    private String subId;


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
     * 整改状态  0 无需整改 1,2,3,4.....需要整改的数量
     */
    private String status;

    /**
     * 子集
     */
    private List<RectifyVO> rectifyList;

}
