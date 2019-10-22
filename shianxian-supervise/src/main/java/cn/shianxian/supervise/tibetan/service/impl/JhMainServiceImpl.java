package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.dao.JhMainDao;
import cn.shianxian.supervise.tibetan.pojo.JhSub;
import cn.shianxian.supervise.tibetan.service.JhMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JhMainServiceImpl implements JhMainService {

    @Autowired
    private JhMainDao jhMainDao;
    @Override
    public Result selectPurchaseInfoByjhkhdm(String jhkhdm) {
        List<JhSub> jhMains = this.jhMainDao.selectPurchaseInfo(jhkhdm);
        return Result.data(jhMains);
    }
}
