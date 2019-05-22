package cn.shianxian.supervise.plan.service.impl;

import cn.shianxian.supervise.info.vo.SuperviseInfoVO;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.dao.SupervisePlanMainDao;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import cn.shianxian.supervise.plan.service.SupervisePlanMainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            List<SupervisePlanMain> planMainList = this.supervisePlanMainDao.selectSupervisePlanMainById(queryPojo.getId());
            return Result.data(planMainList);
        } else if (null != queryPojo.getName() && null != queryPojo.getStartTime() && null != queryPojo.getEndTime()) {
            List<List<?>> list = this.supervisePlanMainDao.selectSupervisePlanMainByLike(queryPojo, pages);
            return Result.data(list);
        }
        return Result.data(null);
    }


    @Override
    public Result selectSupervisePlanByNode(String nodeTag, Pages pages) {
        List<List<?>> list = this.supervisePlanMainDao.selectSupervisePlanByNode(nodeTag, pages);
        return Result.data(list);
    }


    @Override
    public Result selectSupervisePlanDetailByIds(Integer planTag) {
        List<SuperviseInfoVO> planList = this.supervisePlanMainDao.selectSupervisePlanDetailByIds(planTag);
        return Result.data(planList);
    }
}
