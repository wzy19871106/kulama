package cn.shianxian.supervise.face.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * 人脸识别表
 */
@Data
@Table(name = "t_Face_Recognition")
public class FaceRecognition {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`faceTag`")
    private Long faceTag;

    /**
     * 特征值
     */
    @Column(name = "`eigenValue`")
    @Size(message = "特征值过长！", max = 5000)
    private String eigenValue;

    /**
     * 名称
     */
    @Column(name = "`name`")
    @Size(message = "名称过长！", max = 50)
    private String name;

    /**
     * 图片路径
     */
    @Column(name = "`picAddress`")
    @Size(message = "图片路径过长！", max = 255)
    private String picAddress;

    /**
     * 负责人编码
     */
    @Transient
    private String functionaryTag;
}
