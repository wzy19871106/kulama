package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessNodeVO {

    /**
     * 雷达图
     */
    private CockpitAssessRadarVO cockpitAssessRadarVO;

    /**
     * 柱状图、折线图
     */
    private CockpitAssessCompositeVO cockpitAssessCompositeVO;

}
