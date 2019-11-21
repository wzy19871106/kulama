package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessCompositeVO {

    /**
     * 各监管类型的考核评议柱状图、折线图
     */
    private List<CockpitAssessCompositeSuperviseTypeVO> cockpitAssessCompositeSuperviseTypeVOList;

}
