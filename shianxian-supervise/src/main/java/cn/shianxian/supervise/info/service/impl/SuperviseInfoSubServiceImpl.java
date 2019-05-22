package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoSubServiceImpl implements SuperviseInfoSubService {


    @Autowired
    private SuperviseInfoSubDao superviseInfoSubDao;


    @Override
    public Result selectSuperviseRectifyByNode(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseRectifyByNode(nodeTag, pages);
        return Result.data(list);
    }


    @Override
    public Result selectSuperviseRectifyById(String id, Pages pages) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseRectifyById(id, pages);
        return Result.data(list);
    }


    @Override
    public Result selectSuperviseInfoSubById(String id) {
        SuperviseInfoSub infoSub =  this.superviseInfoSubDao.selectSuperviseInfoSubById(id);
        return Result.data(infoSub);
    }


    @Transactional
    @Override
    public Result updateSuperviseInfoSubById(SuperviseInfoSub superviseInfoSub) {
        String res = this.superviseInfoSubDao.updateSuperviseInfoSubById(superviseInfoSub);
        return Result.successMsg();
    }
}
