package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserDao extends Mapper<User> {
}
