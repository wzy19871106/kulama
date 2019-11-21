package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitPlanAreaCompositeVO {

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 各区县的各监管类型计划任务统计数据
     */
    private List<CockpitPlanAreaSuperviseTypeCompositeVO> cockpitPlanAreaSuperviseTypeCompositeVOList;

    /**
     * 各区县计划任务完成情况柱状图
     */
    private List<List<Object>> superviseTypeBarList;

}
