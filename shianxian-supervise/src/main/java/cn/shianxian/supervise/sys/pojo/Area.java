package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_area")
public class Area {


    /**
     * 区域id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "areaTag")
    private String areaTag;

    /**
     * 父id
     */
    @Column(name = "parentAreaTag")
    private String parentAreaTag;

    /**
     * 地区名称
     */
    @Column(name = "areaName")
    private String areaName;

    /**
     * 地区级别
     */
    @Column(name = "areaLevel")
    private String areaLevel;

    /**
     * 地区启用 0启用 1不启用
     */
    @Column(name = "areaDisable")
    private String areaDisable;


}
