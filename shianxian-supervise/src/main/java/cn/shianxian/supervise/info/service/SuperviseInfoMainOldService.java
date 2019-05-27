package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;

public interface SuperviseInfoMainOldService {


    /**
     * 保存线下监管业务主表
     * @param superviseInfoMainOld
     * @return
     */
    Result saveSuperviseInfoMainOld(SuperviseInfoMainOld superviseInfoMainOld);


    /**
     * 根据登录用户的数据访问权限查询线下监管日志列表
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoMainOldByLike(QueryPojo queryPojo, Pages pages);
}
