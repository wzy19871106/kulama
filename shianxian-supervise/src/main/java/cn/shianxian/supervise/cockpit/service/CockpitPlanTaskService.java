package cn.shianxian.supervise.cockpit.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface CockpitPlanTaskService {
    /**
     * 查询驾驶舱计划任务数据
     *
     * @return
     */
    ResponseEntity<Result> selectCockpitPlan();
}
