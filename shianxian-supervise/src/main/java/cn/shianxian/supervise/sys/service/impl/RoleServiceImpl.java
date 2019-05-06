package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.RoleDao;
import cn.shianxian.supervise.sys.pojo.Role;
import cn.shianxian.supervise.sys.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            this.roleDao.insertRole(role);
            log.info("保存角色：{}", role);
        } else {
            this.roleDao.updateRole(role);
            log.info("修改角色：{}", role);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectRoleByPage(QueryPojo queryPojo, Pages pages) {
        List<List<?>> roles = this.roleDao.selectRoleByLike(queryPojo, pages);
        return Result.data(roles);
    }


    @Transactional
    @Override
    public Result deleteRoleById(String id) {
        this.roleDao.deleteRoleById(id);
        log.info("删除角色：{}", id);
        return Result.successMsg();
    }


}
