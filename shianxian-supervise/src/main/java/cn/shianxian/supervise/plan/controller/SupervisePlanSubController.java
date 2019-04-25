package cn.shianxian.supervise.plan.controller;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanSub;
import cn.shianxian.supervise.plan.service.SupervisePlanSubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 子计划任务控制器
 */
@RestController
@RequestMapping("spervisePlanSub")
@Api(description = "子计划任务控制器")
public class SupervisePlanSubController {


    @Autowired
    private SupervisePlanSubService supervisePlanSubService;


    /**
     * 保存、修改子计划任务
     * @return
     */
    @PostMapping("saveOrUpdateSupervisePlanSub")
    @ApiOperation(value = "保存、修改子计划任务接口", notes = "保存、修改子计划任务接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "ids", value = "自增编号"),
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "主任务编号"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "计划监管类型(多个用半角逗号隔开）"),
            @ApiImplicitParam(paramType = "query", name = "superviseTime", value = "监管时间"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamName", value = "执法队伍名称"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDone", value = "完成情况", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveOrUpdateSupervisePlanSub(@Valid SupervisePlanSub supervisePlanSub) {
        Result result = this.supervisePlanSubService.saveOrUpdateSupervisePlanSub(supervisePlanSub);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除子计划任务
     * @return
     */
    @DeleteMapping("deleteSupervisePlanSubById")
    @ApiOperation(value = "删除子计划任务接口", notes = "删除子计划任务接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSupervisePlanSubById(String ids) {
        Result result = this.supervisePlanSubService.deleteSupervisePlanSubById(ids);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询子计划任务
     * @return
     */
    @GetMapping("selectSupervisePlanSub")
    @ApiOperation(value = "查询子计划任务", notes = "查询子计划任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "parentId", value = "父id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectSupervisePlanSub(QueryPojo queryPojo) {
        Result result = this.supervisePlanSubService.selectSupervisePlanSub(queryPojo);
        return ResponseEntity.ok(result);
    }


}
