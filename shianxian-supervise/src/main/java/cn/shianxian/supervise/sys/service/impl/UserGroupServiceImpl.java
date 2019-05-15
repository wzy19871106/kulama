package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @Transactional
    @Override
    public ResponseEntity<Result> deleteUserGroupById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.userGroupDao.deleteUserGroupById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectUserGroup(QueryPojo queryPojo, Pages pages) {
        Object userGroupList = null;
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            userGroupList = this.userGroupDao.selectUserGroupById(queryPojo.getId());
        } else if (null != queryPojo.getParentId() && null != queryPojo.getName()) {
            userGroupList = this.userGroupDao.selectUserGroupByLike(queryPojo, pages);
        }
        return Result.data(userGroupList);
    }


    @Override
    public Result selectUserGroupTree(String id) {
        String tree = this.userGroupDao.selectUserGroupTree(id);
        return Result.data(tree);
    }
}
