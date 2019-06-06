package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainTypeDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoMainServiceImpl implements SuperviseInfoMainService {


    @Autowired
    private SuperviseInfoMainDao superviseInfoMainDao;

    @Autowired
    private SuperviseInfoMainTypeDao superviseInfoMainTypeDao;

    @Autowired
    private SuperviseInfoSubDao superviseInfoSubDao;


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
    public Result saveSuperviseInfo(SuperviseInfoMain superviseInfoMain) {
        this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
        List<SuperviseInfoMainType> superviseInfoMainTypes = superviseInfoMain.getSuperviseInfoMainTypes();
        for (SuperviseInfoMainType superviseInfoMainType : superviseInfoMainTypes) {
            this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
            List<SuperviseInfoSub> superviseInfoSubs = superviseInfoMainType.getSuperviseInfoSubs();
            for (SuperviseInfoSub superviseInfoSub : superviseInfoSubs) {
                this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
            }
            this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(superviseInfoMainType.getMainIds());
        }
        return Result.successMsg();
    }
}
