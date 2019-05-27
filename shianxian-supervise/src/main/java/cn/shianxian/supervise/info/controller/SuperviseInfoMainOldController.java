package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;
import cn.shianxian.supervise.info.service.SuperviseInfoMainOldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 线下监管业务主表控制器
 */
@RestController
@RequestMapping("superviseInfoMainOld")
@Api(description = "监管业务（主表）控制器")
public class SuperviseInfoMainOldController {


    @Autowired
    private SuperviseInfoMainOldService superviseInfoMainOldService;


    /**
     * 保存线下监管业务主表
     * @return
     */
    @PostMapping("superviseInfoMainOld")
    @ApiOperation(value = "保存线下监管业务主表", notes = "保存线下监管业务主表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务主键"),
            @ApiImplicitParam(paramType = "query", name = "parentMainId", value = "监管业务父ID"),
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务编号（非计划任务监管可为空)"),
            @ApiImplicitParam(paramType = "query", name = "planIDs", value = "计划任务子任务编号（非计划任务监管可为空）"),
            @ApiImplicitParam(paramType = "query", name = "nodeType", value = "企业类型"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "监管日期"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamName", value = "执法队伍名称"),
            @ApiImplicitParam(paramType = "query", name = "superviserTag", value = "执法人员编码"),
            @ApiImplicitParam(paramType = "query", name = "superviserName", value = "执法人员名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人编码"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "整改状态  0 无需整改 1,2,3,4.....需要整改的数量"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "附件路径"),
            @ApiImplicitParam(paramType = "query", name = "ifVisit", value = "回访状态"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除"),
    })
    public ResponseEntity<Result> saveSuperviseInfoMainOld(@Valid SuperviseInfoMainOld superviseInfoMainOld) {
        Result result = this.superviseInfoMainOldService.saveSuperviseInfoMainOld(superviseInfoMainOld);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限查询线下监管日志列表
     * @return
     */
    @GetMapping("superviseInfoMainOld")
    @ApiOperation(value = "根据登录用户的数据访问权限查询线下监管日志列表", notes = "根据登录用户的数据访问权限查询线下监管日志列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoMainOldByLike(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainOldService.selectSuperviseInfoMainOldByLike(queryPojo, pages);
        return ResponseEntity.ok(result);
    }

}