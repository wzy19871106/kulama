package cn.shianxian.supervise.team.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.team.pojo.Superviser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviserDao extends Mapper<Superviser> {


    /**
     * 根据id查询执法人员
     * @param id
     * @return
     */
    List<Superviser> selectSuperviserById(@Param("id") String id);


    /**
     * 保存执法人员
     * @param superviser
     * @return
     */
    String insertSuperviser(@Param("superviser") Superviser superviser);


    /**
     * 修改执法人员
     * @param superviser
     * @return
     */
    String updateSuperviser(@Param("superviser") Superviser superviser);


    /**
     * 删除执法人员
     * @param id
     * @return
     */
    String deleteSuperviserById(@Param("id") String id);


    /**
     * 模糊查询执法人员
     * @param queryPojo
     * @return
     */
    List<Superviser> selectSuperviserByLike(@Param("queryPojo") QueryPojo queryPojo);


}
