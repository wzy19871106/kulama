package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 线下监管业务导入表
 */
@Data
@Table(name = "t_SuperviseInfoOldImport")
public class SuperviseInfoOldImport {


    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    /**
     * 文件名
     */
    @Column(name = "fileName")
    private String fileName;

    /**
     * 导入时间
     */
    @Column(name = "importTime")
    private LocalDateTime importTime;

    /**
     * 导入结果 0为导入失败，1为导入成功
     */
    @Column(name = "importResult")
    private String importResult;

}
