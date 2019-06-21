package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(message = "角色标识过长！", max = 50)
    private String roleTag;

    /**
     * 权限标识
     */
    @Column(name = "AuthorityTag")
    @Size(message = "权限标识过长！", max = 5000)
    private String authorityTag;

    /**
     * 模块标识
     */
    @Column(name = "moduleTag")
    @Size(message = "模块标识过长！", max = 50)
    private String moduleTag;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;


    /**
     * 角色id数组
     */
    @Transient
    private String[] ids;

    /**
     * 模块权限
     */
    @Transient
    private String moduleAuthority;
}
