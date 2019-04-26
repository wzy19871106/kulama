package cn.shianxian.supervise.team.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.pojo.SuperviseTeam;

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
    Result deleteSuperviseTeamById(String ids);


    /**
     * 查询执法队伍
     * @param queryPojo
     * @return
     */
    Result selectSuperviseTeam(QueryPojo queryPojo);

}
