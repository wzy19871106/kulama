package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubOldDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSubOld;
import cn.shianxian.supervise.info.service.SuperviseInfoSubOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoSubOldServiceImpl implements SuperviseInfoSubOldService {


    @Autowired
    private SuperviseInfoSubOldDao superviseInfoSubOldDao;


    @Override
    public Result selectSuperviseInfoOldDetail(SuperviseInfoSubOld superviseInfoSubOld) {
        List<SuperviseInfoSubOld> list = this.superviseInfoSubOldDao.selectSuperviseInfoOldDetail(superviseInfoSubOld);
        return Result.data(list);
    }


    @Transactional
    @Override
    public Result saveSuperviseInfoSubOld(SuperviseInfoSubOld superviseInfoSubOld) {
        this.superviseInfoSubOldDao.saveSuperviseInfoSubOld(superviseInfoSubOld);
        return Result.successMsg();
    }
}
