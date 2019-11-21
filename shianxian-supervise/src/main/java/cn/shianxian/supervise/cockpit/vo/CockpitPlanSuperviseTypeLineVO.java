package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CockpitPlanSuperviseTypeLineVO {

    /**
     * 监管类型编码
     */
    @JsonIgnore
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 巡查任务数
     */
    private List<Integer> finishTaskNum;

}
