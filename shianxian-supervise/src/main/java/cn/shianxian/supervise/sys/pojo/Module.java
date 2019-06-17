package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 模块
 */
@Data
@Table(name = "t_module")
public class Module {


    /**
     * 模块标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "moduleTag")
    @Size(message = "模块标识过长！", max = 50)
    private String moduleTag;

    /**
     * 父模块标识编号
     */
    @Column(name = "parentTag")
    @Size(message = "父模块标识编号过长！", max = 50)
    private String parentTag;

    /**
     * 模块名称
     */
    @Column(name = "moduleName")
    @Size(message = "模块名称过长！", max = 200)
    private String moduleName;

    /**
     * 图标
     */
    @Column(name = "moduleIcon")
    @Size(message = "图标过长！", max = 200)
    private String moduleIcon;

    /**
     * 模块url
     */
    @Column(name = "moduleUrl")
    @Size(message = "模块url过长！", max = 200)
    private String moduleUrl;

    /**
     * 模块是否隐藏
     */
    @Column(name = "moduleDisabled")
    private String moduleDisabled;

    /**
     * 模块位置，6位以上数字
     */
    @Column(name = "`order`")
    @Size(message = "模块位置过长！", max = 20)
    private String order;

    /**
     * 模块摘要
     */
    @Column(name = "moduleDescription")
    @Size(message = "模块摘要过长！", max = 200)
    private String moduleDescription;

    /**
     * 是否目录
     */
    @Column(name = "ifMenu")
    private String ifMenu;

    /**
     * 模块流水号
     */
    @Column(name = "`index`")
    private Long index;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 父模块名称
     */
    @Transient
    private String parentModuleName;
}
