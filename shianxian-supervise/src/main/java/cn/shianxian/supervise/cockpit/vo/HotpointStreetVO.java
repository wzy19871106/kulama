package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;

@Data
public class HotpointStreetVO {
    /**
     * 街道名称
     */
    private String streetName;

    /**
     * 街道坐标
     */
    @JsonIgnore
    private String streetCoordinate;

    /**
     * 街道坐标
     */
    private List<Double> coordinate;

    /**
     * 商户数量
     */
    private int companyNum;
}
