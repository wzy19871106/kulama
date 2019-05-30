package cn.shianxian.supervise.team.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.dao.SuperviserDao;
import cn.shianxian.supervise.team.pojo.Superviser;
import cn.shianxian.supervise.team.service.SuperviserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperviserServiceImpl implements SuperviserService {


    @Autowired
    private SuperviserDao superviserDao;


    @Transactional
    @Override
    public Result saveSuperviser(Superviser superviser) {
        this.superviserDao.insertSuperviser(superviser);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateSuperviser(Superviser superviser) {
        this.superviserDao.updateSuperviser(superviser);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteSuperviserById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviserDao.deleteSuperviserById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviser(QueryPojo queryPojo, Pages pages) {
        List<Superviser> superviserList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            superviserList = this.superviserDao.selectSuperviserById(queryPojo.getId());
        } else if (null != queryPojo.getParentId() && null != queryPojo.getName()) {
            List<List<?>> list = this.superviserDao.selectSuperviserByLike(queryPojo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data(superviserList);
    }


    @Transactional
    @Override
    public Result bindSuperviser(Superviser superviser) {
        if (1 == superviser.getType()) {
            this.superviserDao.bindSuperviser(superviser);
        } else if (2 == superviser.getType()) {
            this.superviserDao.unBindSuperviser(superviser);
        }
        return Result.successMsg();
    }

}
