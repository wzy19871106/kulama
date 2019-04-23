package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.SuperviseType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseTypeDao extends Mapper<SuperviseType> {


    /**
     * 保存监管类型
     * @param superviseType
     * @return
     */
    String insertSuperviseType(@Param("superviseType") SuperviseType superviseType);


    /**
     * 修改监管类型
     * @param superviseType
     * @return
     */
    String updateSuperviseType(@Param("superviseType") SuperviseType superviseType);


    /**
     * 删除监管类型
     * @param id
     * @return
     */
    String deleteSuperviseType(@Param("id") String id);


    /**
     * 根据id查询监管类型
     * @param id
     * @return
     */
    List<SuperviseType> selectSuperviseTypeById(@Param("id") String id);


    /**
     * 根据id查询监管类型
     * @param id
     * @return
     */
    String updateSuperviseTypeBySort(@Param("id") String id);
}
