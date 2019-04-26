package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;

public interface RoleAuthorityService {


    /**
     * 保存角色权限
     * @param roleAuthority
     * @return
     */
    Result saveRoleAuthority(RoleAuthority roleAuthority);


    /**
     * 修改角色权限
     * @param roleAuthority
     * @return
     */
    Result updateRoleAuthority(RoleAuthority roleAuthority);


    /**
     * 删除角色权限
     * @param ids
     * @return
     */
    Result deleteRoleAuthorityById(String ids);
}
