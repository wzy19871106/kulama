package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.service.RedisService;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.exception.CommonException;
import cn.shianxian.supervise.sys.dao.UserDao;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.pojo.User;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @Autowired
    private UserGroupDao userGroupDao;


    @Autowired
    private RedisService redisService;


    @Override
    public Result selectUserByPage(User user, Pages pages) {
        List<User> users = new ArrayList<>();
        if (StringUtils.isNotBlank(user.getUserTag())) {
            users = this.userDao.selectUserById(user.getUserTag());
        } else if (null != user.getUserName() && null != user.getRoleTag() && null != user.getUserGroupTag()) {
            List<List<?>> list = this.userDao.selectUserByLike(user, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data((long) users.size(), users);
    }


    @Transactional
    @Override
    public Result updatePassword(String id, String password) {
        User user = new User();
        user.setUserTag(id);
        user.setUserLoginPass(DigestUtils.md5Hex(password));
        this.userDao.updateByPrimaryKeySelective(user);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> saveOrUpdateUser(User user) {
        if (StringUtils.isNotBlank(user.getUserLoginPass())) {
            user.setUserLoginPass(DigestUtils.md5Hex(user.getUserLoginPass()));
        }
        if (StringUtils.isBlank(user.getUserTag())) {
            User u = new User();
            u.setUserLoginName(user.getUserLoginName());
            List<User> userList = this.userDao.select(u);
            if (!userList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Result.msg("用户登录名已存在！"));
            }
            this.userDao.insertUser(user);
        } else {
            this.userDao.updateUser(user);
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result login(String username, String password) {
        User user = new User();
        user.setUserLoginName(username);
        user.setUserLoginPass(DigestUtils.md5Hex(password));
        List<User> userList = this.userDao.select(user);
        if (1 == userList.size()) {
            User loginUser = userList.get(0);
            loginUser.setUserLastTime(LocalDateTime.now());
            this.userDao.updateByPrimaryKeySelective(user);
            String token = UUIDGenerator.generatorUUID();
            this.redisService.set(Constants.USER + token, JSON.toJSONString(loginUser), 14400);
            log.info("web用户登录：{}", loginUser);
            UserGroup userGroup = this.userGroupDao.selectByPrimaryKey(loginUser.getUserGroupTag());
            if (userGroup != null) {
                loginUser.setUserGroupTag(userGroup.getUserDataAuthority());
            }
            loginUser.setToken(token);
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
    public ResponseEntity<Result> deleteUserById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.userDao.deleteUserById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectUserByNoBind(String userNo) {
        User user = this.userDao.selectUserByNoBind(userNo);
        return Result.data(user);
    }

}
