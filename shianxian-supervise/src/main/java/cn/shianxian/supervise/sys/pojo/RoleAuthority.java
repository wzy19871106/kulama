package cn.shianxian.supervise.sys.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.*;


/**
 * 角色模块权限
 */
@Data
@Table(name = "T_Roleauthority")
public class RoleAuthority extends BasePojo {

    
    /**
     * 流水编号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色标识
     */
    @Column(name = "RoleTag")
    private String roleTag;

    /**
     * 权限标识
     */
    @Column(name = "AuthorityTag")
    private String authorityTag;

    /**
     * 模块标识
     */
    @Column(name = "moduleTag")
    private String moduleTag;

    /**
     * 权限id
     */
    @Transient
    private String authoritys;

    /**
     * 模块id
     */
    @Transient
    private String modules;
}
