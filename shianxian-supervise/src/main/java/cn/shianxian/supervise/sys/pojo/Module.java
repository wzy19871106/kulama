package cn.shianxian.supervise.sys.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 模块
 */
@Data
@Table(name = "t_modules")
public class Module extends BasePojo {


    /**
     * 模块标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String moduleTag;

    /**
     * 父模块标识编号
     */
    private String parentTag;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     *图标
     */
    private String moduleIcon;

    /**
     * 模块位置
     */
    private String moduleUrl;

    /**
     * 模块是否隐藏
     */
    private String moduleDisabled;

    /**
     * 模块位置，6位以上数字
     */
    private String order;

    /**
     * 模块摘要
     */
    private String moduleDescription;

    /**
     * 是否目录
     */
    private String ifMenu;

    /**
     * 模块流水号
     */
    private Long index;

}
