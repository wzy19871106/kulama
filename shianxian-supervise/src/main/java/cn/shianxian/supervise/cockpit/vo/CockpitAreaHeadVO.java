package cn.shianxian.supervise.cockpit.vo;
import lombok.Data;

import java.util.List;

@Data
public class CockpitAreaHeadVO {
    /**
     * 热点图区级标识
     */
    private String superviseTypeTagstr;

    /**
     * 热点图街道对象
     */
    private List<HotpointAreaVO> HotpointAreaVOList;
}
