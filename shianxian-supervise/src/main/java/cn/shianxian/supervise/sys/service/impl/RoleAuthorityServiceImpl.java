package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.RoleAuthorityDao;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import cn.shianxian.supervise.sys.service.RoleAuthorityService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RoleAuthorityServiceImpl implements RoleAuthorityService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;


    @Transactional
    @Override
    public Result saveRoleAuthority(RoleAuthority roleAuthority) {
        RoleServiceImpl roleService = new RoleServiceImpl();
        Map<String, List<String>> map = roleService.getAuthority(roleAuthority.getModuleAuthority());
        roleAuthority.setModuleAuthority(JSON.toJSONString(map));
        if (null != roleAuthority.getIds()) {
            String[] ids = roleAuthority.getIds();
            for (String id : ids) {
                roleAuthority.setRoleTag(id);
                this.roleAuthorityDao.insertRoleAuthority(roleAuthority);
            }
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result updateRoleAuthority(RoleAuthority roleAuthority) {
        RoleServiceImpl roleService = new RoleServiceImpl();
        Map<String, List<String>> map = roleService.getAuthority(roleAuthority.getModuleAuthority());
        roleAuthority.setModuleAuthority(JSON.toJSONString(map));
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


    @Override
    public Result selectAuthorityByRoleId(String id) {
        // 查询角色权限
        List<RoleAuthority> list = this.roleAuthorityDao.selectAuthorityByRoleId(id);
        // 拼接数据，模块id + 权限id
        List<String> ids = new ArrayList<>();
        for (RoleAuthority roleAuthority : list) {
            String authorityTag = roleAuthority.getAuthorityTag();
            String[] authIds = authorityTag.split(",");
            for (String authId : authIds) {
                ids.add(roleAuthority.getModuleTag() + authId);
            }
        }
        return Result.data(ids);
    }
}
