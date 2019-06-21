package cn.shianxian.supervise.government.vo;


import lombok.Data;

/**
 * 监管类型数据
 */
@Data
public class TypeColumnVO {


    /**
     * 监管类型id
     */
    private String superviseTypeTag;


    /**
     * 监管类型名称
     */
    private String SuperviseTypeName;


    /**
     * 本期分数
     */
    private Double thisYearScore;


    /**
     * 上期分数
     */
    private Double lastYearScore;

}
