package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleDao extends Mapper<Role> {

    /**
     * 获取角色拥有的权限
     * @param id
     * @return
     */
    List<String> selectAuthorityById(@Param("id") String id);


    /**
     * 保存角色
     * @param role
     * @return
     */
    String insertRole(@Param("role") Role role);


    /**
     * 修改角色
     * @param role
     * @return
     */
    String updateRole(@Param("role") Role role);


    /**
     * 删除角色
     * @param id
     * @return
     */
    String deleteRoleById(@Param("id") String id);
}
