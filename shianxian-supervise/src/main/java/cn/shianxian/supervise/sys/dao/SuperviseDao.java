package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Supervise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseDao extends Mapper<Supervise> {


    /**
     * 保存监管结果
     * @param supervise
     * @return
     */
    String insertSupervise(@Param("supervise") Supervise supervise);


    /**
     * 修改监管结果
     * @param supervise
     * @return
     */
    String updateSupervise(@Param("supervise") Supervise supervise);


    /**
     * 删除监管结果
     * @param id
     * @return
     */
    String deleteSupervise(@Param("id") String id);


    /**
     * 根据id查询监管结果
     * @param id
     * @return
     */
    List<Supervise> selectSuperviseById(@Param("id") String id);


    /**
     * 根据监管内容编码查询监管结果
     * @param type
     * @return
     */
    List<Supervise> selectSuperviseByType(@Param("type") String type);


    /**
     * 监管结果向上排序
     * @param id
     * @return
     */
    String updateSuperviseByUpSort(@Param("id") String id);


    /**
     * 监管结果向下排序
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
}
