package cn.shianxian.supervise.plan.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;
import org.springframework.http.ResponseEntity;

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
    ResponseEntity<Result> deleteSupervisePlanSubById(String ids);


    /**
     * 查询子计划任务
     * @param queryPojo
     * @return
     */
    Result selectSupervisePlanSub(QueryPojo queryPojo, Pages pages);


    /**
     * 根据主任务编码，关键字查询主任务下所有未完成的子任务，显示计划任务名称，企业名称，计划检查时间，检查类型
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSupervisePlanSubList(QueryPojo queryPojo, Pages pages);
}
