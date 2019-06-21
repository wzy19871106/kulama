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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperviseTeamServiceImpl implements SuperviseTeamService {


    @Autowired
    private SuperviseTeamDao superviseTeamDao;


    @Transactional
    @Override
    public ResponseEntity<Result> saveSuperviseTeam(SuperviseTeam superviseTeam) {
        String flag = this.superviseTeamDao.insertSuperviseTeam(superviseTeam);
        if ("A002".equals(flag)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Result.msg("编码已存在！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }



    @Transactional
    @Override
    public Result updateSuperviseTeam(SuperviseTeam superviseTeam) {
        this.superviseTeamDao.updateSuperviseTeam(superviseTeam);
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteSuperviseTeamById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviseTeamDao.deleteSuperviseTeamById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }

        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviseTeam(QueryPojo queryPojo, Pages pages) {
        List<SuperviseTeam> superviseTeams = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            superviseTeams = this.superviseTeamDao.selectSuperviseTeamById(queryPojo.getId());
        } else if (null != queryPojo.getName()) {
            List<List<?>> list = this.superviseTeamDao.selectSuperviseTeamByLike(queryPojo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
        }
        return Result.data(superviseTeams);
    }


    @Override
    public Result selectSuperviseTeamByUserId(String id) {
        SuperviseTeam team = this.superviseTeamDao.selectSuperviseTeamByUserId(id);
        return Result.data(team);
    }
}
