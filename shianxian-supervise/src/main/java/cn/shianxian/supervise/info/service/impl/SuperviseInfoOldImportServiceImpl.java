package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoOldImportDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOldImport;
import cn.shianxian.supervise.info.service.SuperviseInfoOldImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoOldImportServiceImpl implements SuperviseInfoOldImportService {


    @Autowired
    private SuperviseInfoOldImportDao superviseInfoOldImportDao;


    @Transactional
    @Override
    public Result saveSuperviseInfoOldImport(SuperviseInfoOldImport superviseInfoOldImport) {
        this.superviseInfoOldImportDao.saveSuperviseInfoOldImport(superviseInfoOldImport);
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseInfoOldImport(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoOldImportDao.selectSuperviseInfoOldImport(queryPojo, pages);
        return Result.data(list);
    }
}
