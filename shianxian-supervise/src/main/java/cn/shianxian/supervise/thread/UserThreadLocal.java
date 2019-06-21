package cn.shianxian.supervise.thread;

import cn.shianxian.supervise.sys.pojo.User;

/**
 * @Auther: 赵明明
 * @Description: 用户本地线程
 */
public class UserThreadLocal {


    // 本地线程，存放登录用户信息
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();


    /**
     * 储存用户
     * @param user
     */
    public static void setUser(User user) {
        userThreadLocal.set(user);
    }


    /**
     * 获取用户
     */
    public static User getUser() {
        return userThreadLocal.get();
    }

}
