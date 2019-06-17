package cn.shianxian.supervise.government.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * 栏目信息表
 */
@Table(name = "t_column")
@Data
public class Columned {

    /**
     * 栏目标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`columnTag`")
    private Long columnTag;

    /**
     * 栏目名称
     */
    @Column(name = "`columnName`")
    @NotEmpty(message = "栏目名称不能为空！")
    @Size(message = "栏目名称过长！", max = 200)
    private String columnName;

    /**
     * 是否启用
     */
    @Column(name = "`columnDisable`")
    @Size(message = "是否启用过长！", max = 1)
    private String columnDisable;

}
