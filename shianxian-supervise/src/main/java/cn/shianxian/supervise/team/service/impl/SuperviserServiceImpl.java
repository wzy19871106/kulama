package cn.shianxian.supervise.team.service.impl;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.dao.SuperviserDao;
import cn.shianxian.supervise.team.pojo.Superviser;
import cn.shianxian.supervise.team.service.SuperviserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result deleteSuperviserById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.superviserDao.deleteSuperviserById(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviser(QueryPojo queryPojo) {
        List<Superviser> superviserList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            superviserList = this.superviserDao.selectSuperviserById(queryPojo.getId());
        }
        if (StringUtils.isNoneBlank(queryPojo.getParentId(), queryPojo.getName())) {
            superviserList = this.superviserDao.selectSuperviserByLike(queryPojo);
        }
        return Result.data(superviserList);
    }

}
