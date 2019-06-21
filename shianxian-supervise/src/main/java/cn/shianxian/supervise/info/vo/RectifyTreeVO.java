package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.util.List;

/**
 * 整改建议VO
 */
@Data
public class RectifyTreeVO {


    /**
     * 整改建议内容
     */
    private List<RectifyVO> rectifys;


    /**
     * 整改建议汇总
     */
    private RectifySumVO rectifySum;
}
