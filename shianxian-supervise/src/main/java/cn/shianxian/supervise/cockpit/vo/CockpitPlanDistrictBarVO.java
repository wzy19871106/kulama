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

}
