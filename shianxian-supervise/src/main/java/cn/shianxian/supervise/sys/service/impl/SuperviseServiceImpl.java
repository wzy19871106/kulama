package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseDao;
import cn.shianxian.supervise.sys.pojo.Supervise;
import cn.shianxian.supervise.sys.service.SuperviseService;
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
public class SuperviseServiceImpl implements SuperviseService {


    @Autowired
    private SuperviseDao superviseDao;


    @Override
    public Result selectSupervise(Supervise supervise) {
        List<Supervise> superviseList = new ArrayList<>();
        if (StringUtils.isNotBlank(supervise.getSuperviseTag())) {
            superviseList = this.superviseDao.selectSuperviseById(supervise.getSuperviseTag());
        }
        if (StringUtils.isNotBlank(supervise.getSuperviseTypeTag())) {
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
    public ResponseEntity<Result> deleteSuperviseById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviseDao.deleteSupervise(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> updateSuperviseBySort(String id, int type) {
        String flag = null;
        if (1 == type) {
            flag = this.superviseDao.updateSuperviseByUpSort(id);
        }
        if (2 == type) {
            flag = this.superviseDao.updateSuperviseByDownSort(id);
        }
        if (!"O001".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.failMsg());
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviseScore(String id) {
        Double score = this.superviseDao.selectSuperviseScore(id);
        return Result.data(score);
    }


    @Override
    public Result selectSuperviseTree(String type) {
        String tree = this.superviseDao.selectSuperviseTree(type);
        return Result.data(tree);
    }


    @Override
    public Result selectSuperviseAllTree(String type) {
        String tree = this.superviseDao.selectSuperviseAllTree(type);
        return Result.data(tree);
    }
}
