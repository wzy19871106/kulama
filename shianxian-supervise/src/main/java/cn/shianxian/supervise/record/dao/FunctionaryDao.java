package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.record.pojo.Functionary;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FunctionaryDao extends Mapper<Functionary> {
}
