package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessRadarMaxVO {

    public CockpitAssessRadarMaxVO(String name, Double max) {
        this.name = name;
        this.max = max;
    }

    /**
     * 评议指标名称
     */
    private String name;

    /**
     * 评议指标最大值
     */
    private Double max;

}
