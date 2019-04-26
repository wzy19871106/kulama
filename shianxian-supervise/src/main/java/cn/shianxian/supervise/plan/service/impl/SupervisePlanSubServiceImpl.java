package cn.shianxian.supervise.plan.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.dao.SupervisePlanSubDao;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;
import cn.shianxian.supervise.plan.service.SupervisePlanSubService;
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
public class SupervisePlanSubServiceImpl implements SupervisePlanSubService {


    @Autowired
    private SupervisePlanSubDao supervisePlanSubDao;


    @Transactional
    @Override
    public Result saveOrUpdateSupervisePlanSub(SupervisePlanSub supervisePlanSub) {
        if (null == supervisePlanSub.getIds()) {
            this.supervisePlanSubDao.insertSupervisePlanSub(supervisePlanSub);
        } else {
            String s = this.supervisePlanSubDao.updateSupervisePlanSub(supervisePlanSub);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSupervisePlanSubById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.supervisePlanSubDao.deleteSupervisePlanSubById(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSupervisePlanSub(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<SupervisePlanSub> planSubsList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            planSubsList = this.supervisePlanSubDao.selectSupervisePlanSubById(queryPojo.getId());
        } else if (StringUtils.isNotBlank(queryPojo.getName()) && null != queryPojo.getStartTime() && null != queryPojo.getEndTime()) {
            planSubsList = this.supervisePlanSubDao.selectSupervisePlanSubByLike(queryPojo);
        }
        return Result.data(page.getTotal(), planSubsList);
    }
}
