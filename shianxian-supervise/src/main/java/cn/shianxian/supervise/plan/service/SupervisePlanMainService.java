package cn.shianxian.supervise.plan.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import org.springframework.http.ResponseEntity;

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
    ResponseEntity<Result> deleteSupervisePlanMainById(String ids);


    /**
     * 查询计划任务
     * @param queryPojo
     * @return
     */
    Result selectSupervisePlanMain(QueryPojo queryPojo, Pages pages);


    /**
     * 根据节点id查询计划任务
     * @param nodeTag
     * @param pages
     * @return
     */
    Result selectSupervisePlanByNode(String nodeTag, Pages pages);


    /**
     * 据子类型编码查询所有监管内容，按类型分组展示
     * @param planTag
     * @return
     */
    Result selectSupervisePlanDetailByIds(String planTag, String nodeTag);


    /**
     * 根据登录用户的所属执法队伍及关键字关联查询计划任务主、从表，显示任务名称，任务时间、子任务完成进度等信息
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSupervisePlanMainList(QueryPojo queryPojo, Pages pages);
}
