package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainTypeDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import cn.shianxian.supervise.info.service.SuperviseInfoMainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuperviseInfoMainTypeServiceImpl implements SuperviseInfoMainTypeService {


    @Autowired
    private SuperviseInfoMainTypeDao superviseInfoMainTypeDao;


    @Transactional
    @Override
    public Result saveSuperviseInfoMainType(SuperviseInfoMainType superviseInfoMainType) {
        this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateSuperviseInfoMainType(String mainIds) {
        this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(mainIds);
        return Result.successMsg();
    }
}
