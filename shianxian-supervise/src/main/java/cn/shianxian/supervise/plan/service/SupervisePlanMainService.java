package cn.shianxian.supervise.plan.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;

public interface SupervisePlanMainService {


    /**
     * 保存、修改计划任务
     * @param supervisePlanMain
     * @return
     */
    Result saveOrUpdateSupervisePlanMain(SupervisePlanMain supervisePlanMain);


    /**
     * 删除计划任务
     * @param ids
     * @return
     */
    Result deleteSupervisePlanMainById(String ids);


    /**
     * 查询计划任务
     * @param queryPojo
     * @return
     */
    Result selectSupervisePlanMain(QueryPojo queryPojo);
}
