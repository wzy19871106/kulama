package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.sys.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDao extends Mapper<User> {


    /**
     * 保存用户
     * @param User
     * @return
     */
    String insertUser(@Param("user") User User);


    /**
     * 修改用户
     * @param User
     * @return
     */
    String updateUser(@Param("user") User User);


    /**
     * 删除用户
     * @param id
     * @return
     */
    String deleteUserById(@Param("id") String id);


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    List<User> selectUserById(@Param("id") String id);


    /**
     * 模糊查询用户
     * @param user
     * @return
     */
    List<List<?>> selectUserByLike(@Param("user") User user, @Param("pages") Pages pages);

}
