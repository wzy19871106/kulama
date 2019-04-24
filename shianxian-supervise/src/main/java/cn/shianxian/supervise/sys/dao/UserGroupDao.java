package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

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
}
