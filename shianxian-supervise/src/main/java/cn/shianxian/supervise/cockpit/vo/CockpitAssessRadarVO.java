package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CockpitAssessRadarVO {

    /**
     * 雷达图最大值
     */
    private List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOList;

    /**
     * 雷达图实际值
     */
    private List<CockpitAssessRadarActualVO> cockpitAssessRadarActualVOList;

}
