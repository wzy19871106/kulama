package cn.shianxian.supervise.government.vo;


import lombok.Data;

/**
 * 监管内容数据饼图
 */
@Data
public class PieTypeVO {


    /**
     * 监管类型名称
     */
    private String name;


    /**
     * 百分比
     */
    private Double value;

}
