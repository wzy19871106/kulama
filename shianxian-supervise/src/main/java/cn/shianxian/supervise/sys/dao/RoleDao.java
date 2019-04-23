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
}
