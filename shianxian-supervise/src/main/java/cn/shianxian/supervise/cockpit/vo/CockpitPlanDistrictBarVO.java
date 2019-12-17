package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitPlanDistrictBarVO {

    /**
     * 监管所名称
     */
    private String districtName;

    /**
     * 完成情况百分比
     */
    private String percent;

    /**
     * 完成量
     */
    private String finishTaskNum;

    /**
     * 任务总量
     */
    private String planTaskNum;

}
