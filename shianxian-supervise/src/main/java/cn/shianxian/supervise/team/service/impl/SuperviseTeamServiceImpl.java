package cn.shianxian.supervise.team.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.dao.SuperviseTeamDao;
import cn.shianxian.supervise.team.pojo.SuperviseTeam;
import cn.shianxian.supervise.team.service.SuperviseTeamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SuperviseTeamServiceImpl implements SuperviseTeamService {


    @Autowired
    private SuperviseTeamDao superviseTeamDao;


    @Transactional
    @Override
    public Result saveSuperviseTeam(SuperviseTeam superviseTeam) {
        this.superviseTeamDao.insertSuperviseTeam(superviseTeam);
        return Result.successMsg();
    }



    @Transactional
    @Override
    public Result updateSuperviseTeam(SuperviseTeam superviseTeam) {
        this.superviseTeamDao.updateSuperviseTeam(superviseTeam);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteSuperviseTeamById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            this.superviseTeamDao.deleteSuperviseTeamById(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseTeam(QueryPojo queryPojo, Pages pages) {
        Object superviseTeams = null;
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            superviseTeams = this.superviseTeamDao.selectSuperviseTeamById(queryPojo.getId());
        } else if (StringUtils.isNoneEmpty(queryPojo.getName())) {
            superviseTeams = this.superviseTeamDao.selectSuperviseTeamByLike(queryPojo, pages);
        }
        return Result.data(superviseTeams);
    }
}
