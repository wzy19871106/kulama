package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseInfoMainOldDao extends Mapper<SuperviseInfoMainOld> {


    /**
     * 保存线下监管业务主表
     * @param superviseInfoMainOld
     */
    String saveSuperviseInfoMainOld(@Param("superviseInfoMainOld") SuperviseInfoMainOld superviseInfoMainOld);


    /**
     * 根据登录用户的数据访问权限查询线下监管日志列表
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoMainOldByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);
}
