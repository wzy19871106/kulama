package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Table(name = "t_area")
public class Area {


    /**
     * 区域id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "areaTag")
    @Size(message = "区域id过长！", max = 9)
    private String areaTag;

    /**
     * 父id
     */
    @Column(name = "parentAreaTag")
    @Size(message = "区域父id过长！", max = 9)
    private String parentAreaTag;

    /**
     * 地区名称
     */
    @Column(name = "areaName")
    @Size(message = "地区名称过长！", max = 200)
    private String areaName;

    /**
     * 地区级别
     */
    @Column(name = "areaLevel")
    @Size(message = "地区级别过长！", max = 1)
    private String areaLevel;

    /**
     * 地区启用 0启用 1不启用
     */
    @Column(name = "areaDisable")
    private String areaDisable;


}
