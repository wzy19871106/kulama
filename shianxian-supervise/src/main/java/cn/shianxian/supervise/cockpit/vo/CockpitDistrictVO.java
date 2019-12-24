package cn.shianxian.supervise.cockpit.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_district")
public class CockpitDistrictVO {

    /**
     * 监管所编码
     */
    @Column(name="districtTag")
    private String districtTag;

    /**
     * 监管所名称
     */
    @Column(name="districtName")
    private String districtName;

    /**
     * 监管所长名称
     */
    @Column(name="districterName")
    private String districterName;

    /**
     * 监管所电话
     */
    @Column(name="districtTel")
    private String districtTel;

    /**
     * 监管所地址
     */
    @Column(name="districtAddr")
    private String districtAddr;

    /**
     * 监管所坐标
     */
    @Column(name="districtCoordinate")
    private String districtCoordinate;

}
