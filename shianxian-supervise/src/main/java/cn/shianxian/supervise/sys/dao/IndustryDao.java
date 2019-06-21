package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Industry;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface IndustryDao extends Mapper<Industry> {


    /**
     * 查询经济行业
     * @return
     */
    List<Industry> selectIndustry();
}
