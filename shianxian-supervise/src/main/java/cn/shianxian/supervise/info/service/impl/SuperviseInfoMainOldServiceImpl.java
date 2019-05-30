package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainOldDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;
import cn.shianxian.supervise.info.service.SuperviseInfoMainOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoMainOldServiceImpl implements SuperviseInfoMainOldService {


    @Autowired
    private SuperviseInfoMainOldDao superviseInfoMainOldDao;


    @Transactional
    @Override
    public Result saveSuperviseInfoMainOld(SuperviseInfoMainOld superviseInfoMainOld) {
        this.superviseInfoMainOldDao.saveSuperviseInfoMainOld(superviseInfoMainOld);
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseInfoMainOldByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainOldDao.selectSuperviseInfoMainOldByLike(queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }
}
