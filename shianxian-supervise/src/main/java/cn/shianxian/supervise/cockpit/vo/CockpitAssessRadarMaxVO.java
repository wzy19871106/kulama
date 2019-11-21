package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessRadarMaxVO {

    /**
     * 评议指标名称
     */
    private String name;

    /**
     * 评议指标最大值
     */
    private int max;

}
