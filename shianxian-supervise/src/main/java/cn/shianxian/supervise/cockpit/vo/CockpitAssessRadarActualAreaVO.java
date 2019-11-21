package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessRadarActualAreaVO {

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 考核评议实际分值
     */
    private List<Double> scoreList;

    /**
     * 考核评议实际分值
     */
    @JsonIgnore
    private CockpitAssessRadarActualAreaScoreVO cockpitAssessRadarActualAreaScoreVO;
}
