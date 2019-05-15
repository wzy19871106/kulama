package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 数据权限模板
 */
@Data
@Table(name = "T_Usergroup")
public class UserGroup {


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
    @Column(name = "parentTag")
    private String parentTag;

    /**
     * 数据权限名称
     */
    @Column(name = "userGroupName")
    private String userGroupName;

    /**
     * 数据权限是否启用
     */
    @Column(name = "userGroupDisabled")
    private Integer userGroupDisabled;

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

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;


    /**
     * 父名称
     */
    @Transient
    @Column(name = "parentName")
    private String parentName;
}
