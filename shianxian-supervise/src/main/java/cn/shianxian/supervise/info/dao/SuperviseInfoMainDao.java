package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
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
    List<List<?>> selectSuperviseInfoByNode(String nodeTag, Pages pages);
}
