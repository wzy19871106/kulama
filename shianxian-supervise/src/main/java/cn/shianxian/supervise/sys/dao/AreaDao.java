package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AreaDao extends Mapper<Area> {


    /**
     * 根据id查询区域
     * @param id
     * @return
     */
    List<Area> selectAreaById(@Param("id") String id);


    /**
     * 根据父id查询区域
     * @param parentId
     * @return
     */
    List<Area> selectAreaByParentId(@Param("parentId") String parentId);
}
