package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitPlanAreaSuperviseTypeCompositeVO {

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 计划数
     */
    private int planTaskNum;

    /**
     * 实际检查数
     */
    private int finishTaskNum;

    /**
     * 抽查数
     */
    private int dailycheckNum;

}
