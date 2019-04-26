package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseTypeDao;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result deleteSuperviseTypeById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.superviseTypeDao.deleteSuperviseType(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseType(SuperviseType superviseType, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<SuperviseType> superviseTypes = this.superviseTypeDao.selectSuperviseType(superviseType.getSuperviseTypeTag(), superviseType.getUserGroupDataAuthority());
        return Result.data(page.getTotal(), superviseTypes);
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

}
