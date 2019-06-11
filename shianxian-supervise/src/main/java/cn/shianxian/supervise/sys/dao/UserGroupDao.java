package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserGroupDao extends Mapper<UserGroup> {

    /**
     * 新增用户组
     * @param userGroup
     * @return
     */
    String insertUserGroup(@Param("userGroup") UserGroup userGroup);


    /**
     * 修改用户组
     * @param userGroup
     * @return
     */
    String updateUserGroup(@Param("userGroup") UserGroup userGroup);


    /**
     * 删除用户组
     * @param id
     */
    String deleteUserGroupById(@Param("id") String id);


    /**
     * 根据id查询用户组
     * @param id
     */
    List<UserGroup> selectUserGroupById(@Param("id") String id);


    /**
     * 模糊查询用户组
     * @param queryPojo
     */
    List<List<?>> selectUserGroupByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 查询用户组（树形）
     * @param id
     * @return
     */
    String selectUserGroupTree(@Param("id") String id, @Param("flag") boolean flag);
}
