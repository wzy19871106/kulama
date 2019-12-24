package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessCompositeLineVO {

    /**
     * 考核评议时间
     */
    private Integer assessTime;

    /**
     * 考核评议得分
     */
    private Double assessScore;
}
