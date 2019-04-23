package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.sys.dao.SuperviseTypeDao;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SuperviseTypeServiceImpl implements SuperviseTypeService {


    @Autowired
    private SuperviseTypeDao SuperviseTypeDao;


    @Transactional
    @Override
    public Result saveOrUpdateSuperviseType(SuperviseType SuperviseType) {
        if (StringUtils.isBlank(SuperviseType.getSuperviseTypeTag())) {
            SuperviseType.setSuperviseTypeTag(UUIDGenerator.generatorUUID());
            this.SuperviseTypeDao.insertSelective(SuperviseType);
        } else {
            this.SuperviseTypeDao.updateByPrimaryKeySelective(SuperviseType);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSuperviseTypeById(String id) {
        String[] ids = id.split(",");
        List<String> list = new ArrayList<>(ids.length);
        Collections.addAll(list, ids);
        SuperviseType superviseType = new SuperviseType();
        superviseType.setIfDelete(1);
        Example example = new Example(SuperviseType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("superviseTypeTag", list);
        int i = this.SuperviseTypeDao.updateByExampleSelective(superviseType, example);
        return Result.successMsg();
    }

}
