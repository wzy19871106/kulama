package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RoleDao extends Mapper<Role> {
}
