package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessRadarActualVO {
    /**
     * 评议指标名称
     */
    private String name;

    /**
     * 评议指标数值
     */
    private Double value;
}
