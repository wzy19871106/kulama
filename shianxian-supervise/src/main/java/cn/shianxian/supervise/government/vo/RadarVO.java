package cn.shianxian.supervise.government.vo;


import lombok.Data;

/**
 * 监管内容数据饼图
 */
@Data
public class RadarVO {


    /**
     * 整体分析名称
     */
    private String name;

    /**
     * 整体分析数量
     */
    private Double num;

    /**
     * 整体分析值
     */
    private Double value;

}
