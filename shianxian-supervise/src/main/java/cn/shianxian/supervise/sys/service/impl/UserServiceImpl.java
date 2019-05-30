package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.MD5Utils;
import cn.shianxian.supervise.exception.CommonException;
import cn.shianxian.supervise.sys.dao.UserDao;
import cn.shianxian.supervise.sys.pojo.User;
import cn.shianxian.supervise.sys.service.UserService;
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
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public Result selectUserByPage(User user, Pages pages) {
        List<User> users = new ArrayList<>();
        if (StringUtils.isNotBlank(user.getUserTag())) {
            users = this.userDao.selectUserById(user.getUserTag());
        } else if (null != user.getUserName() && null != user.getRoleTag() && null != user.getUserGroupTag()) {
            List<List<?>> list = this.userDao.selectUserByLike(user, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data(users);
    }


    @Transactional
    @Override
    public Result updatePassword(String id, String password) {
        User user = new User();
        user.setUserTag(id);
        user.setUserLoginPass(MD5Utils.md5(password));
        this.userDao.updateByPrimaryKeySelective(user);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result saveOrUpdateUser(User user) {
        if (StringUtils.isBlank(user.getUserTag())) {
            User u = new User();
            u.setUserLoginName(user.getUserLoginName());
            List<User> userList = this.userDao.select(u);
            if (!userList.isEmpty()) {
                return Result.msg("用户登录名已存在！");
            }
            user.setUserLoginPass(MD5Utils.md5(user.getUserLoginPass()));
            this.userDao.insertUser(user);
        } else {
            this.userDao.updateUser(user);
        }
        return Result.successMsg();
    }


    @Override
    public Result login(String username, String password) {
        User user = new User();
        user.setUserLoginName(username);
        user.setUserLoginPass(MD5Utils.md5(password));
        List<User> userList = this.userDao.select(user);
        if (1 == userList.size()) {
            User loginUser = userList.get(0);
            loginUser.setUserLastTime(LocalDateTime.now());
            this.userDao.updateByPrimaryKeySelective(user);
            log.info("用户：{}登录", loginUser);
            return Result.data(loginUser);
        }
        user.setUserLoginPass(null);
        List<User> users = this.userDao.select(user);
        if (1 == users.size()) {
            User u = users.get(0);
            u.setUserErrCount(u.getUserErrCount() + 1);
            this.userDao.updateByPrimaryKeySelective(u);
        }
        throw new CommonException(Constants.UNAUTHORIZED, "用户名密码不正确");
    }


    @Transactional
    @Override
    public Result deleteUserById(String id) {
        this.userDao.deleteUserById(id);
        log.info("删除用户：{}", id);
        return Result.successMsg();
    }

}
