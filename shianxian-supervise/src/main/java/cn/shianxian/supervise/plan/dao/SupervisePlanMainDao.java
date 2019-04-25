package cn.shianxian.supervise.plan.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SupervisePlanMainDao extends Mapper<SupervisePlanMain> {

    /**
     * 根据id查询模块
     * @param id
     * @return
     */
    List<SupervisePlanMain> selectSupervisePlanMainById(@Param("id") String id);


    /**
     * 保存模块
     * @param supervisePlanMain
     * @return
     */
    String insertSupervisePlanMain(@Param("supervisePlanMain") SupervisePlanMain supervisePlanMain);


    /**
     * 修改模块
     * @param supervisePlanMain
     * @return
     */
    String updateSupervisePlanMain(@Param("supervisePlanMain") SupervisePlanMain supervisePlanMain);


    /**
     * 删除模块
     * @param id
     * @return
     */
    String deleteSupervisePlanMainById(@Param("id") String id);


    /**
     * 模糊查询模块
     * @param queryPojo
     * @return
     */
    List<SupervisePlanMain> selectSupervisePlanMainByLike(@Param("queryPojo") QueryPojo queryPojo);


}
