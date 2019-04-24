package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.UserGroup;

public interface UserGroupService {

    /**
     * 保存、修改用户组
     * @param userGroup
     * @return
     */
    Result saveOrUpdateUserGroup(UserGroup userGroup);
}
