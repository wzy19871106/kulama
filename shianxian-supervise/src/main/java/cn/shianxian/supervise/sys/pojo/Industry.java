package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_Industry")
public class Industry {


    /**
     * 行业编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "industryTag")
    private String industryTag;

    /**
     * 行业名称
     */
    @Column(name = "industryName")
    private String industryName;


}
