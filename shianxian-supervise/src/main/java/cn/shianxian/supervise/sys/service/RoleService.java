package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Role;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    /**
     * 保存、修改角色
     * @param role
     * @return
     */
    Result saveOrUpdateRole(Role role);


    /**
     * 分页查询角色
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectRoleByPage(QueryPojo queryPojo, Pages pages);


    /**
     * 删除角色
     * @param id
     * @return
     */
    ResponseEntity<Result> deleteRoleById(String id);

}
