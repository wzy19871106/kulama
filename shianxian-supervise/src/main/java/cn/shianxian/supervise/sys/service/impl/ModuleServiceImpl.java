package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.ModuleDao;
import cn.shianxian.supervise.sys.pojo.Module;
import cn.shianxian.supervise.sys.service.ModuleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {


    @Autowired
    private ModuleDao moduleDao;


    @Override
    public Result selectModule(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<Module> modules = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            modules = this.moduleDao.selectModuleById(queryPojo.getId());
        }
        if (StringUtils.isNoneBlank(queryPojo.getParentId(), queryPojo.getName())) {
            modules = this.moduleDao.selectModuleByLike(queryPojo);
        }
        return Result.data(page.getTotal(), modules);
    }


    @Override
    public Result checkModule(Module module) {
        String s = this.moduleDao.checkModule(module);
        return Result.data(s);
    }


    @Transactional
    @Override
    public Result saveOrUpdateModule(Module module) {
        if (StringUtils.isBlank(module.getModuleTag())) {
            this.moduleDao.insertModule(module);
        } else {
            this.moduleDao.updateModule(module);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteModuleById(String id) {
        this.moduleDao.deleteModuleById(id);
        return Result.successMsg();
    }


    @Override
    public Result selectModuleByTree(String id) {
        List<Module> modules = this.moduleDao.selectModuleByTree(id);
        return Result.data(modules);
    }


}
