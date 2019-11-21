package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitPlanLineVO {

    /**
     * 巡查任务区县走势图
     */
    private List<CockpitPlanAreaLineVO> cockpitPlanAreaLineVOList;

    /**
     * 巡查任务监管类型走势图
     */
    private List<CockpitPlanSuperviseTypeLineVO> cockpitPlanSuperviseTypeLineVOList;
}
