package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CockpitAreaVO {

    /**
     * 热点图区级标识
     */
    @JsonIgnore
    private String areaTag;

    /**
     * 热点图区级名称
     */
    private String areaName;

}
