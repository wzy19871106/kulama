package cn.shianxian.supervise.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionDao {

    /**
     * 根据id查询app版本号
     */

    String selectAppVersion();
}
