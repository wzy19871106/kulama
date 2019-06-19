package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Supervise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseDao extends Mapper<Supervise> {


    /**
     * 保存监管内容
     * @param supervise
     * @return
     */
    String insertSupervise(@Param("supervise") Supervise supervise);


    /**
     * 修改监管内容
     * @param supervise
     * @return
     */
    String updateSupervise(@Param("supervise") Supervise supervise);


    /**
     * 删除监管内容
     * @param id
     * @return
     */
    String deleteSupervise(@Param("id") String id);


    /**
     * 根据id查询监管内容
     * @param id
     * @return
     */
    List<Supervise> selectSuperviseById(@Param("id") String id);


    /**
     * 根据监管内容编码查询监管内容
     * @param type
     * @return
     */
    List<Supervise> selectSuperviseByType(@Param("type") String type);


    /**
     * 监管内容向上排序
     * @param id
     * @return
     */
    String updateSuperviseByUpSort(@Param("id") String id);


    /**
     * 监管内容向下排序
     * @param id
     * @return
     */
    String updateSuperviseByDownSort(@Param("id") String id);


    /**
     * 查询监管内容剩余分值
     * @param id
     * @return
     */
    Double selectSuperviseScore(@Param("id") String id);


    /**
     * 根据类型查询监管内容（树形）
     * @param type
     * @return
     */
    String selectSuperviseTree(@Param("type") String type);


    /**
     * 根据监管类型id查询有父级的监管内容
     * @param id
     * @return
     */
    List<Supervise> selectParentSupervise(@Param("id") String id);


    /**
     * 根据监管内容id查询监管内容的子集内容
     * @param id
     * @return
     */
    List<Supervise> selectSubSupervise(@Param("id") String id);


    /**
     * 根据需要被回访的MainIDS查询父级监管内容
     * @param mainIds
     * @return
     */
    List<Supervise> selectParentSuperviseByParentMainIds(@Param("mainIds") String mainIds);


    /**
     * 根据需要被回访的MainIDS和父级监管内容ID查询子级监管内容
     * @param superviseTag
     * @param mainIds
     * @return
     */
    List<Supervise> selectSubSuperviseByParentMainIds(@Param("superviseTag") String superviseTag, @Param("mainIds") String mainIds);


    /**
     * 根据类型查询所有监管内容（树形）
     * @param type
     * @return
     */
    String selectSuperviseAllTree(@Param("type") String type);
}
