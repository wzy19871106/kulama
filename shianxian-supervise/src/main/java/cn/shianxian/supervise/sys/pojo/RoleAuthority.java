package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * 角色模块权限
 */
@Data
@Table(name = "T_Roleauthority")
public class RoleAuthority {

    
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
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

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
