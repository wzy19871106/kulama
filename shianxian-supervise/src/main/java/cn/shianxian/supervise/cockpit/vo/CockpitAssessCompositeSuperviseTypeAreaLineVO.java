package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessCompositeSuperviseTypeAreaLineVO {

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 考核评议得分
     */
    private List<Double> assessScore;

}
