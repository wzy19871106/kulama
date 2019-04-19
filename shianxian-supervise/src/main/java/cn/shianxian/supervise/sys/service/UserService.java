package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;

public interface UserService {

    /**
     * 分页查询用户
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectUserByPage(QueryPojo queryPojo, Pages pages);
}
