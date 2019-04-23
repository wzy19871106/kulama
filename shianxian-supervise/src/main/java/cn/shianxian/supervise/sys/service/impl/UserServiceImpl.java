package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.MD5Utils;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.exception.CommonException;
import cn.shianxian.supervise.sys.dao.UserDao;
import cn.shianxian.supervise.sys.pojo.User;
import cn.shianxian.supervise.sys.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Result selectUserByPage(QueryPojo queryPojo, Pages pages) {
        Page<Object> page = PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(queryPojo.getId())) {
            criteria.andEqualTo("userTag", queryPojo.getId());
        }
        if (!StringUtils.isEmpty(queryPojo.getName())) {
            criteria.orLike("userName", Constants.PER_CENT + queryPojo.getName() + Constants.PER_CENT);
            criteria.orLike("userLoginName", Constants.PER_CENT + queryPojo.getName() + Constants.PER_CENT);
        }
        if (!StringUtils.isEmpty(queryPojo.getStartTime()) && !StringUtils.isEmpty(queryPojo.getEndTime())) {
            criteria.andBetween("createTime", queryPojo.getStartTime(), queryPojo.getEndTime());
        }
        List<User> users = this.userDao.selectByExample(example);
        return Result.data(page.getTotal(), users);
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
        if (StringUtils.isEmpty(user.getUserTag())) {
            user.setUserTag(UUIDGenerator.generatorUUID());
            user.setCreateTime(LocalDateTime.now());
            this.userDao.insertSelective(user);
        } else {
            this.userDao.updateByPrimaryKeySelective(user);
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
        throw new CommonException(Constants.FORBIDDEN, "用户名密码不正确");
    }


    @Transactional
    @Override
    public Result deleteUserById(String id) {
        this.userDao.deleteByPrimaryKey(id);
        log.info("删除用户：{}", id);
        return Result.successMsg();
    }
}
