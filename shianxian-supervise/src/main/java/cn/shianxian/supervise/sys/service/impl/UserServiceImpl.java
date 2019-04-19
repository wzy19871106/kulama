package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.UserDao;
import cn.shianxian.supervise.sys.pojo.User;
import cn.shianxian.supervise.sys.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
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
}
