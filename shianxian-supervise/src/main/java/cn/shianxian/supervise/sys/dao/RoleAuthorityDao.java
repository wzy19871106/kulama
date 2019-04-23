package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleAuthorityDao extends Mapper<RoleAuthority> {

    /**
     * 批量添加权限
     * @param roleAuthorityList
     * @return
     */
    int insertBatch(@Param("roleAuthorityList") List<RoleAuthority> roleAuthorityList);
}
