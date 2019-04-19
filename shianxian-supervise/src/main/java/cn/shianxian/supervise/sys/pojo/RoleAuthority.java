package cn.shianxian.supervise.sys.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
     * 用户角色标识
     */
    private String roleTag;

    /**
     * 模块权限标识
     */
    private String moduleAuthority;


}
