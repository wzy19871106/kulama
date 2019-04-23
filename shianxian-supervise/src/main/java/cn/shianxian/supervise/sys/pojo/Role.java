package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


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
    private String roleTag;


    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空！")
    @Column(name = "roleName")
    private String roleName;


    /**
     * 角色是否隐藏[1隐藏，0可见]
     */
    @Column(name = "RoleDisabled")
    private String RoleDisabled;

}
