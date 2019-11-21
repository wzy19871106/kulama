package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CockpitSuperviseTypeVO {

    /**
     * 监管类型标识
     */
    @JsonIgnore
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

}
