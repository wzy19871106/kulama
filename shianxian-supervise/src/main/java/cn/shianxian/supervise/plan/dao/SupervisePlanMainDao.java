package cn.shianxian.supervise.plan.dao;

import cn.shianxian.supervise.info.vo.SuperviseInfoVO;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SupervisePlanMainDao extends Mapper<SupervisePlanMain> {

    /**
     * 根据id查询计划任务
     * @param id
     * @return
     */
    List<SupervisePlanMain> selectSupervisePlanMainById(@Param("id") String id);


    /**
     * 保存计划任务
     * @param supervisePlanMain
     * @return
     */
    String insertSupervisePlanMain(@Param("supervisePlanMain") SupervisePlanMain supervisePlanMain);


    /**
     * 修改计划任务
     * @param supervisePlanMain
     * @return
     */
    String updateSupervisePlanMain(@Param("supervisePlanMain") SupervisePlanMain supervisePlanMain);


    /**
     * 删除计划任务
     * @param id
     * @return
     */
    String deleteSupervisePlanMainById(@Param("id") String id);


    /**
     * 模糊查询计划任务
     * @param queryPojo
     * @return
     */
    List<List<?>> selectSupervisePlanMainByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 根据节点id查询计划任务
     * @param nodeTag
     * @param pages
     * @return
     */
    List<List<?>> selectSupervisePlanByNode(@Param("nodeTag") String nodeTag, @Param("pages") Pages pages);


    /**
     * 据子类型编码查询所有监管内容，按类型分组展示
     * @param planTag
     * @return
     */
    List<SuperviseInfoVO> selectSupervisePlanDetailByIds(@Param("planTag") String planTag, @Param("nodeTag") String nodeTag);


    /**
     * 根据登录用户的所属执法队伍及关键字关联查询计划任务主、从表，显示任务名称，任务时间、子任务完成进度等信息
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectSupervisePlanMainList(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);
}
