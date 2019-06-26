package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Module;
import org.springframework.http.ResponseEntity;

public interface ModuleService {

    /**
     * 根据id查询模块
     * @return
     */
    Result selectModule(QueryPojo queryPojo, Pages pages);


    /**
     * 校验模块位置是否存在
     * @param module
     * @return
     */
    Result checkModule(Module module);


    /**
     * 保存、修改模块
     * @param module
     * @return
     */
    Result saveOrUpdateModule(Module module);


    /**
     * 删除模块
     * @param ids
     * @return
     */
    ResponseEntity<Result> deleteModuleById(String ids);


    /**
     * 查询模块（根据树形排序数据）
     * @param id
     * @return
     */
    Result selectModuleByTree(String id);


    /**
     * 查询模块（树形）
     * @return
     */
    Result selectModuleTree();


    /**
     * 查询模块权限（树形）
     * @return
     */
    Result selectModuleAuthorityTree();


    /**
     * 查询模块权限（禁用）（树形）
     * @return
     */
    Result selectModuleAuthorityDisabledTree();


    /**
     * 根据用户id查询模块
     * @param userTag
     * @return
     */
    Result selectModuleByUserId(String userTag);
}
