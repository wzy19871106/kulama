package cn.shianxian.supervise.government.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.government.pojo.Columned;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ColumnedDao extends Mapper<Columned> {


    /**
     * 保存栏目信息
     * @param columned
     */
    String saveColumned(@Param("columned") Columned columned);

    /**
     * 修改栏目信息
     * @param columned
     */
    String updateColumned(@Param("columned") Columned columned);


    /**
     * 删除栏目信息
     * @param columnTag
     */
    String deleteColumned(@Param("columnTag") Long columnTag);


    /**
     * 查询栏目信息
     * @param name
     * @param pages
     * @return
     */
    List<List<?>> selectColumned(@Param("name") String name, @Param("pages") Pages pages);


    /**
     * 根据id查询栏目信息
     * @param columnTag
     * @return
     */
    Columned selectColumnedById(@Param("columnTag") Long columnTag);
}
