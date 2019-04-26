package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.UserGroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    @Transactional
    @Override
    public Result deleteUserGroupById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.userGroupDao.deleteUserGroupById(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectUserGroup(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        List<UserGroup> userGroupList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            userGroupList = this.userGroupDao.selectUserGroupById(queryPojo.getId());
        }
        if (StringUtils.isNoneBlank(queryPojo.getParentId(), queryPojo.getName())) {
            userGroupList = this.userGroupDao.selectUserGroupByLike(queryPojo);
        }
        return Result.data(page.getTotal(), userGroupList);
    }
}
