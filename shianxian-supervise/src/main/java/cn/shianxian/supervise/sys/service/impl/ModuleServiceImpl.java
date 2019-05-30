package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.ModuleDao;
import cn.shianxian.supervise.sys.pojo.Module;
import cn.shianxian.supervise.sys.service.ModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {


    @Autowired
    private ModuleDao moduleDao;


    @Override
    public Result selectModule(QueryPojo queryPojo, Pages pages) {
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            List<Module> modules = this.moduleDao.selectModuleById(queryPojo.getId());
            return Result.data(modules);
        } else if (null != queryPojo.getParentId() && null != queryPojo.getName()) {
            List<List<?>> list = this.moduleDao.selectModuleByLike(queryPojo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data(null);
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


    @Override
    public Result selectModuleTree() {
        String moduleJson = this.moduleDao.selectModuleTree();
        return Result.data(moduleJson);
    }


    @Override
    public Result selectModuleAuthorityTree() {
        String moduleJson = this.moduleDao.selectModuleAuthorityTree();
        return Result.data(moduleJson);
    }


}
