package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitPlanTaskVO {

    /**
     * 全市计划任务总体完成情况监管类型百分比图
     */
    private List<CockpitPlanSuperviseTypeCircleVO> cockpitPlanSuperviseTypeCircleVOList;

    /**
     * 全市计划任务总体完成情况区县柱状图
     */
    private List<List<Object>> cockpitPlanAreaBarList;

    /**
     * 完成情况-监管所排名
     */
    private List<List<Object>> cockpitPlanDistrictBarList;

    /**
     * 各区县计划任务完成情况
     */
    private List<CockpitPlanAreaCompositeVO> cockpitPlanAreaCompositeList;

    /**
     * 巡查任务完成情况
     */
    private CockpitPlanLineVO cockpitPlanLine;


}





