package cn.shianxian.supervise.team.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.team.pojo.SuperviseTeam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseTeamDao extends Mapper<SuperviseTeam> {


    /**
     * 根据id查询执法队伍
     * @param id
     * @return
     */
    List<SuperviseTeam> selectSuperviseTeamById(@Param("id") String id);


    /**
     * 保存执法队伍
     * @param superviseTeam
     * @return
     */
    String insertSuperviseTeam(@Param("superviseTeam") SuperviseTeam superviseTeam);


    /**
     * 修改执法队伍
     * @param superviseTeam
     * @return
     */
    String updateSuperviseTeam(@Param("superviseTeam") SuperviseTeam superviseTeam);


    /**
     * 删除执法队伍
     * @param id
     * @return
     */
    String deleteSuperviseTeamById(@Param("id") String id);


    /**
     * 模糊查询执法队伍
     * @param queryPojo
     * @return
     */
    List<List<?>> selectSuperviseTeamByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 根据用户id查询执法队伍
     * @param id
     * @return
     */
    SuperviseTeam selectSuperviseTeamByUserId(@Param("id") String id);
}
