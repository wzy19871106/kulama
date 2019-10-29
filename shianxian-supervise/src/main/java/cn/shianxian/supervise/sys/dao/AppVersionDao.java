package cn.shianxian.supervise.sys.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionDao {

    /**
     * 查询app版本号,返回更新路径
     */

    String selectAppVersion();

    /**
     * 查询AppPad版本号,返回更新路径
     * @return
     */
    String selectAppPadVersion();
}
