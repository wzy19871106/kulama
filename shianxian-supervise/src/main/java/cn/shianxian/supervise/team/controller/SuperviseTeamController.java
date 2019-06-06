package cn.shianxian.supervise.team.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.pojo.SuperviseTeam;
import cn.shianxian.supervise.team.service.SuperviseTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 执法队伍控制器
 */
@RestController
@RequestMapping("superviseTeam")
@Api(description = "执法队伍控制器")
@Slf4j
public class SuperviseTeamController {


    @Autowired
    private SuperviseTeamService superviseTeamService;


    /**
     * 保存执法队伍
     * @return
     */
    @PostMapping("saveSuperviseTeam")
    @ApiOperation(value = "保存执法队伍接口", notes = "保存执法队伍接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "teamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "teamName", value = "执法队伍名称"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "是否使用", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "位置"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveSuperviseTeam(@Valid SuperviseTeam SuperviseTeam) {
        log.info("保存执法队伍：{}", SuperviseTeam);
        Result result = this.superviseTeamService.saveSuperviseTeam(SuperviseTeam);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改执法队伍
     * @return
     */
    @PutMapping("updateSuperviseTeam")
    @ApiOperation(value = "修改执法队伍接口", notes = "修改执法队伍接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "teamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "teamName", value = "执法队伍名称"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "是否使用", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "位置"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> updateSuperviseTeam(@Valid SuperviseTeam SuperviseTeam) {
        log.info("修改执法队伍：{}", SuperviseTeam);
        Result result = this.superviseTeamService.updateSuperviseTeam(SuperviseTeam);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除执法队伍
     * @return
     */
    @DeleteMapping("deleteSuperviseTeamById")
    @ApiOperation(value = "删除执法队伍接口", notes = "删除执法队伍接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSuperviseTeamById(String ids) {
        log.info("删除执法队伍：{}", ids);
        Result result = this.superviseTeamService.deleteSuperviseTeamById(ids);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询执法队伍
     * @return
     */
    @GetMapping("selectSuperviseTeam")
    @ApiOperation(value = "查询执法队伍", notes = "查询执法队伍")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseTeam(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseTeamService.selectSuperviseTeam(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据用户id查询执法队伍
     * @return
     */
    @GetMapping("selectSuperviseTeamByUserId")
    @ApiOperation(value = "根据用户id查询执法队伍", notes = "根据用户id查询执法队伍")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id")
    public ResponseEntity<Result> selectSuperviseTeamByUserId(String id) {
        Result result = this.superviseTeamService.selectSuperviseTeamByUserId(id);
        return ResponseEntity.ok(result);
    }
}
