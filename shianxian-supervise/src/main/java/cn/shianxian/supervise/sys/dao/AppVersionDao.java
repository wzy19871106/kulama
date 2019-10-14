package cn.shianxian.supervise.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionDao {

    /**
     * 查询app版本号,返回更新路径
     */

    String selectAppVersion();
}
