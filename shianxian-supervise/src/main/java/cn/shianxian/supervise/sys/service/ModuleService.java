package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;

public interface ModuleService {

    /**
     * 查询模块
     * @return
     */
    Result selectModule(String id);
}
