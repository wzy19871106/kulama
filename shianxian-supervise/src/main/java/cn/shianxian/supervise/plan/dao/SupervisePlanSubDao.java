package cn.shianxian.supervise.plan.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SupervisePlanSubDao extends Mapper<SupervisePlanSub> {

    /**
     * 根据id查询子计划任务
     * @param id
     * @return
     */
    List<SupervisePlanSub> selectSupervisePlanSubById(@Param("id") String id);


    /**
     * 保存子计划任务
     * @param supervisePlanSub
     * @return
     */
    String insertSupervisePlanSub(@Param("supervisePlanSub") SupervisePlanSub supervisePlanSub);


    /**
     * 修改子计划任务
     * @param supervisePlanSub
     * @return
     */
    String updateSupervisePlanSub(@Param("supervisePlanSub") SupervisePlanSub supervisePlanSub);


    /**
     * 删除子计划任务
     * @param id
     * @return
     */
    String deleteSupervisePlanSubById(@Param("id") String id);


    /**
     * 模糊查询子计划任务
     * @param queryPojo
     * @return
     */
    List<SupervisePlanSub> selectSupervisePlanSubByLike(@Param("queryPojo") QueryPojo queryPojo);

}
