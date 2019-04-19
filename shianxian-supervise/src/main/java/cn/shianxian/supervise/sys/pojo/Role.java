package cn.shianxian.supervise.sys.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
    private String roleTag;


    /**
     * 角色名称
     */
    private String roleName;

}
