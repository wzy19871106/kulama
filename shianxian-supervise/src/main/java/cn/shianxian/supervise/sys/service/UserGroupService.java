package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.UserGroup;

public interface UserGroupService {

    /**
     * 保存、修改用户组
     * @param userGroup
     * @return
     */
    Result saveOrUpdateUserGroup(UserGroup userGroup);


    /**
     * 删除用户组
     * @param ids
     * @return
     */
    Result deleteUserGroupById(String ids);


    /**
     * 查询用户组
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectUserGroup(QueryPojo queryPojo, Pages pages);
}
