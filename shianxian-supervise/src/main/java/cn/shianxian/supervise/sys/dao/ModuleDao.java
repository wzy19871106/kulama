package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Module;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ModuleDao extends Mapper<Module> {
}
