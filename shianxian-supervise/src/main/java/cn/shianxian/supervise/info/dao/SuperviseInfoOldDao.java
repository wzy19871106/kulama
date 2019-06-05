package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOld;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

@Repository
public interface SuperviseInfoOldDao extends Mapper<SuperviseInfoOld> {


    /**
     * 批量插入
     * @param superviseInfoOlds
     * @return
     */
    int batchInsertSelective(@Param("superviseInfoOlds") Set<SuperviseInfoOld> superviseInfoOlds);


    /**
     * 分组查询导入线下监管信息
     * @param queryPojo
     * @return
     */
    List<SuperviseInfoOld> selectSuperviseInfoOldGroup(@Param("queryPojo") QueryPojo queryPojo);
}
