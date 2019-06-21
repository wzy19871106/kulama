package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(message = "数据权限标识过长！", max = 50)
    private String userGroupTag;

    /**
     * 父数据权限标识
     */
    @Column(name = "parentTag")
    @Size(message = "父数据权限标识过长！", max = 50)
    private String parentTag;

    /**
     * 数据权限名称
     */
    @Column(name = "userGroupName")
    @Size(message = "数据权限名称过长！", max = 200)
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
    @Size(message = "数据权限模板的维度模板过长！", max = 200)
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
    private String parentName;
}
