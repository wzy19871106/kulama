package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CockpitPlanAreaLineVO {

    /**
     * 区县编码
     */
    @JsonIgnore
    private String areaTag;

    /**
     * 区县名称
     */
    private String areaName;

    /**
     * 巡查任务数
     */
    private List<Integer> finishTaskNum;

}
