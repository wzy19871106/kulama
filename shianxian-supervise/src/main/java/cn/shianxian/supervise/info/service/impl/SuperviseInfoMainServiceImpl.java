package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainTypeDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import cn.shianxian.supervise.sys.dao.NodeInfoDao;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.pojo.Supervise;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.thread.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuperviseInfoMainServiceImpl implements SuperviseInfoMainService {


    @Autowired
    private SuperviseInfoMainDao superviseInfoMainDao;

    @Autowired
    private SuperviseInfoMainTypeDao superviseInfoMainTypeDao;

    @Autowired
    private SuperviseInfoSubDao superviseInfoSubDao;

    @Autowired
    private NodeInfoDao nodeInfoDao;


    @Override
    public Result selectSuperviseInfoByNodePlan(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByNodePlan(nodeTag, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByIdPlan(String id, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByIdPlan(id, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByNode(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByNode(nodeTag, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Transactional
    @Override
    public Result saveSuperviseInfoMain(SuperviseInfoMain superviseInfoMain) {
        this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseInfoByPlan(String planTag, String superviseTypeTag, QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByPlan(planTag, superviseTypeTag, queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByLike(queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByRectify(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByRectify(queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Transactional
    @Override
    public Result saveSuperviseInfo(List<SuperviseType> superviseTypeList) {
        SuperviseInfoMain superviseInfoMain = new SuperviseInfoMain();
        boolean flag = true;
        String mainId = UUIDGenerator.generatorUUID();
        for (SuperviseType superviseType : superviseTypeList) {
            if (flag) {
                superviseInfoMain.setMainId(mainId);
                superviseInfoMain.setPlanTag(superviseType.getPlanTag());
                NodeInfo nodeInfo = this.nodeInfoDao.selectByPrimaryKey(superviseType.getNodeTag());
                superviseInfoMain.setNodeType(nodeInfo.getIndustryTag());
                superviseInfoMain.setNodeTag(superviseType.getNodeTag());
                superviseInfoMain.setNodeName(superviseType.getNodeName());
                superviseInfoMain.setCreateTime(LocalDateTime.now());
                superviseInfoMain.setPicTag("");
                // 保存监管主表
                this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
                flag = false;
            }
            SuperviseInfoMainType superviseInfoMainType = new SuperviseInfoMainType();
            String mainIds = UUIDGenerator.generatorUUID();
            superviseInfoMainType.setMainIds(mainIds);
            superviseInfoMainType.setMainId(mainId);
            superviseInfoMainType.setNodeTag(superviseType.getNodeTag());
            superviseInfoMainType.setSuperviseTeamTag(superviseType.getSuperviseTeamTag());
            superviseInfoMainType.setSuperviseTeamName(superviseType.getSuperviseTeamName());
            superviseInfoMainType.setSuperviserTag(superviseType.getSuperviserTag());
            superviseInfoMainType.setSuperviserName(superviseType.getSuperviserName());
            superviseInfoMainType.setFunctionaryTag(superviseType.getFunctionaryTag());
            superviseInfoMainType.setFunctionaryName(superviseType.getFunctionaryName());
            superviseInfoMainType.setParentMainIds("");
            // 保存监管类型
            this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
            // 父级内容
            List<Supervise> superviseList = superviseType.getSuperviseList();
            for (Supervise supervise : superviseList) {
                List<Supervise> subList = supervise.getSuperviseList();
                sub:for (Supervise sub : subList) {
                    List<SuperviseResult> results = sub.getSuperviseResultList();
                    if (results.isEmpty()) {
                        continue sub;
                    }
                    SuperviseInfoSub superviseInfoSub = new SuperviseInfoSub();
                    superviseInfoSub.setMainIds(mainIds);
                    superviseInfoSub.setNodeTag(superviseType.getNodeTag());
                    superviseInfoSub.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
                    superviseInfoSub.setSuperviseTag(results.get(0).getSuperviseTag());
                    superviseInfoSub.setSuperviseName(results.get(0).getSuperviseName());
                    superviseInfoSub.setResultTag(results.get(0).getResultTag());
                    superviseInfoSub.setResultValue(results.get(0).getResultValue());
                    superviseInfoSub.setScore(results.get(0).getScore());
                    superviseInfoSub.setAdvice(results.get(0).getAdvice());
                    superviseInfoSub.setRequst("");
                    superviseInfoSub.setPicTag("");
                    superviseInfoSub.setCreateUserTag(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setLastUpdateUser(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setRemark(sub.getRemark());
                    // 保存监管从表
                    this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
                }
            }
            // 修改监管类型
            this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(superviseInfoMainType.getMainIds());
        }
        return Result.successMsg();
    }
}
