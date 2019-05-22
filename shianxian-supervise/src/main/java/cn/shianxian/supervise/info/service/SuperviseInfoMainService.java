package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;

public interface SuperviseInfoMainService {


    /**
     * 根据节点id查询已完成的计划任务的监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByNodePlan(String nodeTag, Pages pages);


    /**
     * 根据id查询已完成的计划任务的监管业务
     * @param id
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByIdPlan(String id, Pages pages);


    /**
     * 根据节点id查询监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByNode(String nodeTag, Pages pages);
}
