package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessCompositeSuperviseTypeAreaVO {

    /**
     * 区县编码
     */
    @JsonIgnore
    private String areaTag;

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 柱状图
     */
    private List<CockpitAssessCompositeSuperviseTypeAreaBar> cockpitAssessCompositeSuperviseTypeAreaBarList;

    /**
     * 折线图
     */
    private CockpitAssessCompositeSuperviseTypeAreaLineVO cockpitAssessCompositeSuperviseTypeAreaLineVO;

    /**
     * 雷达图
     */
    private CockpitAssessRadarVO cockpitAssessRadarVO;

}
