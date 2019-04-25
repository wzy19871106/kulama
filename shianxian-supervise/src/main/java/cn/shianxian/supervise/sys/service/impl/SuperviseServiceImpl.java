package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseDao;
import cn.shianxian.supervise.sys.pojo.Supervise;
import cn.shianxian.supervise.sys.service.SuperviseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperviseServiceImpl implements SuperviseService {


    @Autowired
    private SuperviseDao superviseDao;


    @Override
    public Result selectSupervise(Supervise supervise) {
        List<Supervise> superviseList = new ArrayList<>();
        if (StringUtils.isNotBlank(supervise.getSuperviseTag())) {
            superviseList = this.superviseDao.selectSuperviseById(supervise.getSuperviseTag());
        } else if (StringUtils.isNotBlank(supervise.getSuperviseTypeTag())) {
            superviseList = this.superviseDao.selectSuperviseByType(supervise.getSuperviseTypeTag());
        }
        return Result.data(superviseList);

    }


    @Transactional
    @Override
    public Result saveOrUpdateSupervise(Supervise supervise) {
        if (StringUtils.isBlank(supervise.getSuperviseTag())) {
            this.superviseDao.insertSupervise(supervise);
            log.info("保存监管内容：{}", supervise);
        } else {
            this.superviseDao.updateSupervise(supervise);
            log.info("修改监管内容：{}", supervise);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSuperviseById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.superviseDao.deleteSupervise(id);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateSuperviseBySort(String id, int type) {
        if (1 == type) {
            this.superviseDao.updateSuperviseByUpSort(id);
        } else if (2 == type) {
            this.superviseDao.updateSuperviseByDownSort(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseScore(String id) {
        Double score = this.superviseDao.selectSuperviseScore(id);
        return Result.data(score);
    }
}
