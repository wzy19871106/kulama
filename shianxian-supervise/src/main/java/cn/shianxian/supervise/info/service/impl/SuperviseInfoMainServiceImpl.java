package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainDao;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperviseInfoMainServiceImpl implements SuperviseInfoMainService {


    @Autowired
    private SuperviseInfoMainDao superviseInfoMainDao;


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
}
