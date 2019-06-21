package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Table(name = "t_Industry")
public class Industry {


    /**
     * 行业编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "industryTag")
    @Size(message = "行业编码过长！", max = 50)
    private String industryTag;

    /**
     * 行业名称
     */
    @Column(name = "industryName")
    @Size(message = "行业名称过长！", max = 100)
    private String industryName;


}
