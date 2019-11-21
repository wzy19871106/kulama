package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class HotpointAreaVO extends CockpitAreaVO{

    /**
     * 热点图区级标识
     */
    private String areaTag;

    /**
     * 热点图街道对象
     */
    private List<HotpointStreetVO> hotpointStreetVOList;

}





