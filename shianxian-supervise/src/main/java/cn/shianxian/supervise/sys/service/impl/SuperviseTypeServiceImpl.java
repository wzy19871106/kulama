package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseTypeDao;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
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
public class SuperviseTypeServiceImpl implements SuperviseTypeService {


    @Autowired
    private SuperviseTypeDao superviseTypeDao;


    @Transactional
    @Override
    public Result saveOrUpdateSuperviseType(SuperviseType SuperviseType) {
        if (StringUtils.isBlank(SuperviseType.getSuperviseTypeTag())) {
            this.superviseTypeDao.insertSuperviseType(SuperviseType);
        } else {
            this.superviseTypeDao.updateSuperviseType(SuperviseType);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteSuperviseTypeById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviseTypeDao.deleteSuperviseType(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviseType(SuperviseType superviseType, Pages pages) {
        List<SuperviseType> superviseTypes = this.superviseTypeDao.selectSuperviseType(superviseType.getSuperviseTypeTag(), superviseType.getUserGroupDataAuthority());
        return Result.data(superviseTypes);
    }


    @Transactional
    @Override
    public Result updateSuperviseTypeBySort(String id, int type) {
        if (1 == type) {
            this.superviseTypeDao.updateSuperviseTypeByUpSort(id);
        }
        if (2 == type) {
            this.superviseTypeDao.updateSuperviseTypeByDownSort(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseTypeTree(SuperviseType superviseType) {
        String tree = this.superviseTypeDao.selectSuperviseTypeTree(superviseType);
        return Result.data(tree);
    }

}
