package cn.shianxian.supervise.info.vo;


import lombok.Data;


/**
 * 整改建议汇总VO
 */
@Data
public class RectifySumVO {


    /**
     * 监管类型名称
     */
    private String superviseTypeName;


    /**
     * 监管日期
     */
    private String createTime;


    /**
     * 整改状态  0 无需整改 1,2,3,4.....需要整改的数量
     */
    private String status;
}
