package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.util.List;

/**
 *  整改建议内容
 */
@Data
public class RectifyVO {

    /**
     * 监管内容id
     */
    private String superviseTag;

    /**
     * 监管内容名称
     */
    private String superviseName;

    /**
     * 子集详情
     */
    private List<RectifyDetailVO> detailList;
}
