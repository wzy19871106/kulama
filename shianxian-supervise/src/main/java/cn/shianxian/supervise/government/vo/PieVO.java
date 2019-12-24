package cn.shianxian.supervise.government.vo;


import lombok.Data;

/**
 * 监管内容数据饼图
 */
@Data
public class PieVO {


    /**
     * 监管内容
     */
    private String superviseName;

    /**
     * 监管数量
     */
    private Integer superviseNum;

    /**
     * 百分比
     */
    private Double percent;

}
