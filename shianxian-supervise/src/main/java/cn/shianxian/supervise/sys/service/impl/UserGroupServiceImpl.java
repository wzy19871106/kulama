package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserGroupServiceImpl implements UserGroupService {


    @Autowired
    private UserGroupDao userGroupDao;


    @Transactional
    @Override
    public Result saveOrUpdateUserGroup(UserGroup userGroup) {
        if (StringUtils.isBlank(userGroup.getUserGroupTag())) {
            this.userGroupDao.insertUserGroup(userGroup);
        } else {
            this.userGroupDao.updateUserGroup(userGroup);
        }
        return Result.successMsg();
    }
}
