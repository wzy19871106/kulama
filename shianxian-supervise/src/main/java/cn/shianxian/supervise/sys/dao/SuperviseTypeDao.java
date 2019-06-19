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
    List<SuperviseType> selectSuperviseType(@Param("id") String id, @Param("userGroupDataAuthority") String userGroupDataAuthority);


    /**
     * 监管类型向上排序
     * @param id
     * @return
     */
    String updateSuperviseTypeByUpSort(@Param("id") String id);


    /**
     * 监管类型向下排序
     * @param id
     * @return
     */
    String updateSuperviseTypeByDownSort(@Param("id") String id);


    /**
     * 查询监管类型（树形）
     * @param superviseType
     * @return
     */
    String selectSuperviseTypeTree(@Param("superviseType") SuperviseType superviseType);


    /**
     * 保存监管类型权限
     * @param superviseType
     * @return
     */
    String saveSuperviseTypeAuthority(@Param("superviseType") SuperviseType superviseType);


    /**
     * 保存、修改监管类型权限
     * @param superviseType
     */
    String updateSuperviseTypeAuthority(@Param("superviseType") SuperviseType superviseType);


    /**
     * 根据需要被回访的MainIDS查询监管类型
     * @param mainIds
     * @return
     */
    List<SuperviseType> selectSuperviseTypeByParentMainIds(@Param("mainIds") String mainIds);


    /**
     * 查询所有监管类型（树形）
     * @param superviseType
     * @return
     */
    String selectSuperviseTypeAllTree(@Param("superviseType") SuperviseType superviseType);
}
