package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessCompositeSuperviseTypeAreaLineVO {

    /**
     * 考核评议时间
     */
//    private List<String> assessDate;

    /**
     * 考核评议得分
     */
    private List<Double> assessScore;

}
