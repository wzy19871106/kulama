package cn.shianxian.supervise.team.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.pojo.SuperviseTeam;
import org.springframework.http.ResponseEntity;

public interface SuperviseTeamService {


    /**
     * 保存执法队伍
     * @param superviseTeam
     * @return
     */
    Result saveSuperviseTeam(SuperviseTeam superviseTeam);


    /**
     * 修改执法队伍
     * @param superviseTeam
     * @return
     */
    Result updateSuperviseTeam(SuperviseTeam superviseTeam);


    /**
     * 删除执法队伍
     * @param ids
     * @return
     */
    ResponseEntity<Result> deleteSuperviseTeamById(String ids);


    /**
     * 查询执法队伍
     * @param queryPojo
     * @return
     */
    Result selectSuperviseTeam(QueryPojo queryPojo, Pages pages);


    /**
     * 根据用户id查询执法队伍
     * @param id
     * @return
     */
    Result selectSuperviseTeamByUserId(String id);
}
