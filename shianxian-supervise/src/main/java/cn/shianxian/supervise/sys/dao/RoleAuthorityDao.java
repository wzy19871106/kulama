package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleAuthorityDao extends Mapper<RoleAuthority> {


    /**
     * 保存角色权限
     * @param roleAuthority
     * @return
     */
    String insertRoleAuthority(@Param("roleAuthority") RoleAuthority roleAuthority);


    /**
     * 修改角色权限
     * @param roleAuthority
     */
    String updateRoleAuthority(@Param("roleAuthority") RoleAuthority roleAuthority);


    /**
     * 删除角色权限
     * @param id
     */
    String deleteRoleAuthorityById(@Param("id") String id);


    /**
     * 根据角色id查询权限
     * @param id
     * @return
     */
    List<RoleAuthority> selectAuthorityByRoleId(String id);
}
