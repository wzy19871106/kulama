package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.ModuleDao;
import cn.shianxian.supervise.sys.pojo.Module;
import cn.shianxian.supervise.sys.service.ModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        List<Module> modules = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            modules = this.moduleDao.selectModuleById(queryPojo.getId());
        } else if (null != queryPojo.getParentId() && null != queryPojo.getName()) {
            List<List<?>> list = this.moduleDao.selectModuleByLike(queryPojo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data((long) modules.size(), modules);
    }


    @Override
    public Result checkModule(Module module) {
        String s = this.moduleDao.checkModule(module);
        boolean flag = false;
        if ("C001".equals(s)) {
            flag = true;
        }
        return Result.data(flag);
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
    public ResponseEntity<Result> deleteModuleById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.moduleDao.deleteModuleById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
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


    @Override

    public Result selectModuleAuthorityDisabledTree() {
        String moduleJson = this.moduleDao.selectModuleAuthorityDisabledTree();
        return Result.data(moduleJson);
    }


    @Override
    public Result selectModuleByUserId(String userTag) {
        String moduleJson = this.moduleDao.selectModuleByUserId(userTag);
        return Result.data(moduleJson);
    }


    @Override
    public Result selectModuleAuthorityByUserTag(String userTag) {
        String moduleJson = this.moduleDao.selectModuleAuthorityByUserTag(userTag);
        return Result.data(moduleJson);
    }


}
