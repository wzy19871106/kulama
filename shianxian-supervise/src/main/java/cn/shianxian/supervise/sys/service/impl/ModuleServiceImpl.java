package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.ModuleDao;
import cn.shianxian.supervise.sys.pojo.Module;
import cn.shianxian.supervise.sys.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {


    @Autowired
    private ModuleDao moduleDao;


    @Override
    public Result selectModule(String id) {
        Example example = new Example(Module.class);
        example.setOrderByClause("moduleTag ASC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentTag", 0);
        List<Module> modules = this.moduleDao.selectByExample(example);
        // 查询子模块
        for (Module module : modules) {
            example.clear();
            Example.Criteria exampleCriteria = example.createCriteria();
            exampleCriteria.andEqualTo("parentTag", module.getModuleTag());
            List<Module> children = this.moduleDao.selectByExample(example);
            module.setChildren(children);
        }
        // 是否选中 TODO
        return Result.data(modules);
    }


}
