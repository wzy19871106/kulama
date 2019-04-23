package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;

public interface RoleAuthorityService {


    /**
     * 设置角色权限
     * @param roleAuthority
     * @return
     */
    Result saveRoleAuthority(RoleAuthority roleAuthority);
}
