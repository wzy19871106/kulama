package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessCompositeSuperviseTypeVO {

    /**
     * 监管类型编码
     */
    @JsonIgnore
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 各监管类型下各区县的折线图、柱状图
     */
    private List<CockpitAssessCompositeSuperviseTypeAreaVO> cockpitAssessCompositeSuperviseTypeAreaVOList;
}
