package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_picinfo")
public class PicInfo {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 图片标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 图片名称
     */
    @Column(name = "picName")
    private String picName;

    /**
     * 图片地址
     */
    @Column(name = "picAddress")
    private String picAddress;

}
