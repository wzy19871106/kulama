package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.RoleAuthorityDao;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import cn.shianxian.supervise.sys.service.RoleAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class RoleAuthorityServiceImpl implements RoleAuthorityService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;


    @Transactional
    @Override
    public Result saveRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthorityDao.insertRoleAuthority(roleAuthority);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthorityDao.updateRoleAuthority(roleAuthority);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteRoleAuthorityById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.roleAuthorityDao.deleteRoleAuthorityById(id);
        }
        return Result.successMsg();
    }
}
