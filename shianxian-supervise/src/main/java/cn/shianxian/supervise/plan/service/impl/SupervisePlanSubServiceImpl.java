package cn.shianxian.supervise.plan.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.dao.SupervisePlanSubDao;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;
import cn.shianxian.supervise.plan.service.SupervisePlanSubService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ResponseEntity<Result> deleteSupervisePlanSubById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.supervisePlanSubDao.deleteSupervisePlanSubById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSupervisePlanSub(QueryPojo queryPojo, Pages pages) {
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            List<SupervisePlanSub> planSubsList = this.supervisePlanSubDao.selectSupervisePlanSubById(queryPojo.getId());
            return Result.data(planSubsList);
        } else if (null != queryPojo.getName() && null != queryPojo.getStartTime() && null != queryPojo.getEndTime()) {
            List<List<?>> list = this.supervisePlanSubDao.selectSupervisePlanSubByLike(queryPojo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data(null);
    }
}
