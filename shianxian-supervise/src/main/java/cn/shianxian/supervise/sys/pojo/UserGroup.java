package cn.shianxian.supervise.sys.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据权限模板
 */
@Data
@Table(name = "T_Usergroup")
public class UserGroup extends BasePojo {


    /**
     * 数据权限标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "userGroupTag")
    private String userGroupTag;

    /**
     * 父数据权限标识
     */
    @Column(name = "userParentTag")
    private String userParentTag;

    /**
     * 数据权限名称
     */
    @Column(name = "userGroupName")
    private String userGroupName;

    /**
     * 数据权限是否启用
     */
    @Column(name = "userGroupDisabled")
    private String userGroupDisabled;

    /**
     * 数据权限模板的维度模板
     */
    @Column(name = "userDataAuthority")
    private String userDataAuthority;

    /**
     * 数据权限图片地址标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 数据权限流水号
     */
    @Column(name = "`index`")
    private Long index;

}
