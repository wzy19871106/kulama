package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * 角色
 */
@Data
@Table(name = "t_Role")
public class Role {


    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "roleTag")
    @Size(message = "角色id过长！", max = 50)
    private String roleTag;


    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空！")
    @Column(name = "roleName")
    @Size(message = "角色名称过长！", max = 200)
    private String roleName;


    /**
     * 角色是否隐藏[1隐藏，0可见]
     */
    @Column(name = "RoleDisabled")
    private String RoleDisabled;


    /**
     * 模块权限JSON
     */
    @Transient
    private String moduleAuthority;

}
