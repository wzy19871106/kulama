package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseResultDao;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import cn.shianxian.supervise.sys.service.SuperviseResultService;
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
public class SuperviseResultServiceImpl implements SuperviseResultService {


    @Autowired
    private SuperviseResultDao superviseResultDao;


    @Transactional
    @Override
    public Result saveSuperviseResult(SuperviseResult superviseResult) {
        this.superviseResultDao.insertSuperviseResult(superviseResult);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateSuperviseResult(SuperviseResult superviseResult) {
        this.superviseResultDao.updateSuperviseResult(superviseResult);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSuperviseResultById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.superviseResultDao.deleteSuperviseResult(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseResult(SuperviseResult superviseResult, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<SuperviseResult> results = new ArrayList<>();
        if (StringUtils.isNotBlank(superviseResult.getResultTag())) {
            results = this.superviseResultDao.selectSuperviseResultById(superviseResult.getResultTag());
        } else if (StringUtils.isNotBlank(superviseResult.getSuperviseTag())) {
            results = this.superviseResultDao.selectSuperviseResultBySuperviseTag(superviseResult.getSuperviseTag());
        }
        return Result.data(page.getTotal(), results);
    }


    @Transactional
    @Override
    public Result updateSuperviseResultBySort(String id, int type) {
        if (1 == type) {
            this.superviseResultDao.updateSuperviseResultByUpSort(id);
        } else if (2 == type) {
            this.superviseResultDao.updateSuperviseResultByDownSort(id);
        }
        return Result.successMsg();
    }
}
