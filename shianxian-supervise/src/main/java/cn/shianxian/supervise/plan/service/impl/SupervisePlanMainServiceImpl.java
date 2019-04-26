package cn.shianxian.supervise.plan.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.dao.SupervisePlanMainDao;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import cn.shianxian.supervise.plan.service.SupervisePlanMainService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SupervisePlanMainServiceImpl implements SupervisePlanMainService {

    @Autowired
    private SupervisePlanMainDao supervisePlanMainDao;


    @Transactional
    @Override
    public Result saveOrUpdateSupervisePlanMain(SupervisePlanMain supervisePlanMain) {
        if (null == supervisePlanMain.getPlanTag()) {
            this.supervisePlanMainDao.insertSupervisePlanMain(supervisePlanMain);
        } else {
            this.supervisePlanMainDao.updateSupervisePlanMain(supervisePlanMain);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSupervisePlanMainById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.supervisePlanMainDao.deleteSupervisePlanMainById(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSupervisePlanMain(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<SupervisePlanMain> planMainList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            planMainList = this.supervisePlanMainDao.selectSupervisePlanMainById(queryPojo.getId());
        } else if (StringUtils.isNotBlank(queryPojo.getName()) && null != queryPojo.getStartTime() && null != queryPojo.getEndTime()) {
            planMainList = this.supervisePlanMainDao.selectSupervisePlanMainByLike(queryPojo);
        }
        return Result.data(page.getTotal(), planMainList);
    }
}
