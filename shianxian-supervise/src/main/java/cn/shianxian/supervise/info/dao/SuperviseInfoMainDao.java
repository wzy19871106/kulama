package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseInfoMainDao extends Mapper<SuperviseInfoMain> {


    /**
     * 根据节点id查询已完成的计划任务的监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoByNodePlan(@Param("nodeTag") String nodeTag, @Param("pages") Pages pages);


    /**
     * 根据id查询已完成的计划任务的监管业务
     * @param id
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoByIdPlan(@Param("id") String id, @Param("pages") Pages pages);


    /**
     * 根据节点id查询监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoByNode(@Param("nodeTag") String nodeTag, @Param("pages") Pages pages);


    /**
     * 保存监管业务（主表）
     * @param superviseInfoMain
     * @return
     */
    String saveSuperviseInfoMain(@Param("superviseInfoMain") SuperviseInfoMain superviseInfoMain);


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表
     * @param planTag
     * @param superviseTypeTag
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoByPlan(@Param("planTag") String planTag, @Param("superviseTypeTag")String superviseTypeTag, @Param("queryPojo")QueryPojo queryPojo, @Param("pages")Pages pages);


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoByLike(@Param("queryPojo")QueryPojo queryPojo, @Param("pages")Pages pages);
}
