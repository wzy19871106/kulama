package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.sys.pojo.SuperviseType;

import java.util.List;

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


    /**
     * 保存监管业务（主表）
     * @param superviseInfoMain
     * @return
     */
    Result saveSuperviseInfoMain(SuperviseInfoMain superviseInfoMain);


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表
     * @param planTag
     * @param superviseTypeTag
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByPlan(String planTag, String superviseTypeTag, QueryPojo queryPojo, Pages pages);


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByLike(QueryPojo queryPojo, Pages pages);


    /**
     * 根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoByRectify(QueryPojo queryPojo, Pages pages);


    /**
     * 保存监管业务
     * @param superviseTypeList
     * @return
     */
    Result saveSuperviseInfo(List<SuperviseType> superviseTypeList);


    /**
     * 保存监管业务(未整改未监管项)
     *
     * @return
     */
    Result saveSuperviseInfoCheck(List<?> JsonResult);

    /**
     * 获取播放视频url
     * @param mainId
     * @return
     */
    Result getVideoUrl(String mainId);
}
