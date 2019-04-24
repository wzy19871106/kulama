package cn.shianxian.supervise.sys.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 模块
 */
@Data
@Table(name = "t_module")
public class Module extends BasePojo {


    /**
     * 模块标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "moduleTag")
    private String moduleTag;

    /**
     * 父模块标识编号
     */
    @Column(name = "parentTag")
    private String parentTag;

    /**
     * 模块名称
     */
    @Column(name = "moduleName")
    private String moduleName;

    /**
     * 图标
     */
    @Column(name = "moduleIcon")
    private String moduleIcon;

    /**
     * 模块位置
     */
    @Column(name = "moduleUrl")
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
    private String order;

    /**
     * 模块摘要
     */
    @Column(name = "moduleDescription")
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


}
