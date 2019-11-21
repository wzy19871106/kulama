package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitPlanAreaBarVO {

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 计划数
     */
    private int planTaskNum;

    /**
     * 完成数
     */
    private int finishTaskNum;

}
