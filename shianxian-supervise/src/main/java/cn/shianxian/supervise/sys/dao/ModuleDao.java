package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.sys.pojo.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ModuleDao extends Mapper<Module> {

    /**
     * 根据id查询模块
     * @param id
     * @return
     */
    List<Module> selectModuleById(@Param("id") String id);


    /**
     * 校验模块位置是否存在
     * @param module
     * @return
     */
    String checkModule(@Param("module") Module module);


    /**
     * 保存模块
     * @param module
     * @return
     */
    String insertModule(@Param("module") Module module);


    /**
     * 修改模块
     * @param module
     * @return
     */
    String updateModule(@Param("module") Module module);


    /**
     * 删除模块
     * @param id
     * @return
     */
    String deleteModuleById(@Param("id") String id);


    /**
     * 模糊查询模块
     * @param queryPojo
     * @return
     */
    List<List<?>> selectModuleByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 查询模块（根据树形排序数据）
     * @param id
     * @return
     */
    List<Module> selectModuleByTree(String id);


    /**
     * 查询模块（树形）
     * @return
     */
    String selectModuleTree();


    /**
     * 查询模块权限（树形）
     * @return
     */
    String selectModuleAuthorityTree();
}
