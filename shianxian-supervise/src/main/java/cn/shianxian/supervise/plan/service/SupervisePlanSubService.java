package cn.shianxian.supervise.plan.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;

public interface SupervisePlanSubService {


    /**
     * 保存、修改子计划任务
     * @param supervisePlanSub
     * @return
     */
    Result saveOrUpdateSupervisePlanSub(SupervisePlanSub supervisePlanSub);


    /**
     * 删除子计划任务
     * @param ids
     * @return
     */
    Result deleteSupervisePlanSubById(String ids);


    /**
     * 查询子计划任务
     * @param queryPojo
     * @return
     */
    Result selectSupervisePlanSub(QueryPojo queryPojo, Pages pages);
}
