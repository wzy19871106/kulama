package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.sys.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleDao extends Mapper<Role> {

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


    /**
     * 模糊查询角色
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectRoleByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);
}
