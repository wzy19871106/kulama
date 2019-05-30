package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.User;

public interface UserService {

    /**
     * 分页查询用户
     * @param user
     * @param pages
     * @return
     */
    Result selectUserByPage(User user, Pages pages);


    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    Result updatePassword(String id, String password);


    /**
     * 保存、修改用户
     * @param user
     * @return
     */
    Result saveOrUpdateUser(User user);


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);


    /**
     * 删除用户
     * @param id
     * @return
     */
    Result deleteUserById(String id);


    /**
     * 查询没有绑定过的用户
     * @param userNo
     * @return
     */
    Result selectUserByNoBind(String userNo);
}
