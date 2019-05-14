package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;

public interface AreaService {

    /**
     * 查询区域
     * @param queryPojo
     * @return
     */
    Result selectArea(QueryPojo queryPojo);
}
