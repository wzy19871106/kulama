package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.RoleAuthorityDao;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import cn.shianxian.supervise.sys.service.RoleAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleAuthorityServiceImpl implements RoleAuthorityService {


    @Autowired
    private RoleAuthorityDao roleAuthorityDao;


    @Transactional
    @Override
    public Result saveRoleAuthority(RoleAuthority roleAuthority) {
        if (StringUtils.isNotBlank(roleAuthority.getAuthoritys())) {
            // 删除之前的权限
            RoleAuthority r = new RoleAuthority();
            r.setRoleTag(roleAuthority.getRoleTag());
            int deleteCount = this.roleAuthorityDao.delete(r);
            log.info("删除权限，数量为：{}", deleteCount);
            String[] ids = roleAuthority.getAuthoritys().split(",");
            List<RoleAuthority> roleAuthorityList = new ArrayList<>();
            for (String id : ids) {
                RoleAuthority ra = new RoleAuthority();
                ra.setRoleTag(roleAuthority.getRoleTag());
                ra.setAuthorityTag(id);
                // TODO
                ra.setModuleTag("1");
                ra.setCreateTime(LocalDateTime.now());
                roleAuthorityList.add(ra);
            }
            this.roleAuthorityDao.insertBatch(roleAuthorityList);
            log.info("角色{}新增权限，数量为：{}", roleAuthority.getRoleTag(), roleAuthorityList.size());
        }
        return Result.successMsg();
    }
}
