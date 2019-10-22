package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.dao.JhMainDao;
import cn.shianxian.supervise.tibetan.pojo.JhSub;
import cn.shianxian.supervise.tibetan.service.JhMainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JhMainServiceImpl implements JhMainService {

    @Autowired
    private JhMainDao jhMainDao;
    @Override
    public Result selectPurchaseDmByjhkhdm(String jhkhdm) {
        String purchaseDm = this.jhMainDao.selectPurchaseDm(jhkhdm);
        if (StringUtils.isNotBlank(purchaseDm)){
            return Result.data(purchaseDm);
        }
        return Result.msg("无数据");
    }

    @Override
    public Result selectPurchaseInfoByjhdm(String jhkhdm, String jhdm, Pages pages) {
        List<JhSub> jhSubs = this.jhMainDao.selectPurchaseInfo(jhkhdm, jhdm,pages);
        if (!jhSubs.isEmpty()){
            return Result.data(jhSubs);
        }
        return Result.msg("无数据");
    }
}
