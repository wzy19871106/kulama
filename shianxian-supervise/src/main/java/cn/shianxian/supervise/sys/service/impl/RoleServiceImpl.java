package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.sys.dao.RoleDao;
import cn.shianxian.supervise.sys.pojo.Role;
import cn.shianxian.supervise.sys.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;


    @Transactional
    @Override
    public Result saveOrUpdateRole(Role role) {
        if (StringUtils.isBlank(role.getRoleTag())) {
            role.setRoleTag(UUIDGenerator.generatorUUID());
            this.roleDao.insertSelective(role);
            log.info("保存角色：{}", role);
        } else {
            this.roleDao.updateByPrimaryKeySelective(role);
            log.info("修改角色：{}", role);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectRoleByPage(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            criteria.andEqualTo("roleTag", queryPojo.getId());
        }
        if (StringUtils.isNotBlank(queryPojo.getName())) {
            criteria.orLike("roleName", Constants.PER_CENT + queryPojo.getName() + Constants.PER_CENT);
        }
        List<Role> roles = this.roleDao.selectByExample(example);
        return Result.data(page.getTotal(), roles);
    }


    @Transactional
    @Override
    public Result deleteRoleById(String id) {
        this.roleDao.deleteByPrimaryKey(id);
        log.info("删除角色：{}", id);
        return Result.successMsg();
    }
}
