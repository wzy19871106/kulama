package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 监管业务（主表）控制器
 */
@RestController
@RequestMapping("sperviseInfoMain")
@Api(description = "监管业务（主表）控制器")
@Slf4j
public class SuperviseInfoMainController {


    @Autowired
    private SuperviseInfoMainService superviseInfoMainService;


    /**
     * 保存监管业务（主表）
     * @return
     */
    @PostMapping("superviseInfoMain")
    @ApiOperation(value = "保存监管业务（主表）", notes = "保存监管业务（主表）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务主键"),
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务编号（非计划任务监管可为空)"),
            @ApiImplicitParam(paramType = "query", name = "nodeType", value = "企业类型"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "监管日期"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "附件路径"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除"),
    })
    public ResponseEntity<Result> saveSuperviseInfoMain(@Valid SuperviseInfoMain superviseInfoMain) {
        log.info("保存监管业务（主表）：{}", superviseInfoMain);
        Result result = this.superviseInfoMainService.saveSuperviseInfoMain(superviseInfoMain);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表
     * @return
     */
    @GetMapping("selectSuperviseInfoByPlan")
    @ApiOperation(value = "根据登录用户的数据访问权限查询计划任务监管日志列表", notes = "根据登录用户的数据访问权限查询计划任务监管日志列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务id"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByPlan(String planTag, String superviseTypeTag, QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByPlan(planTag, superviseTypeTag, queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）
     * @return
     */
    @GetMapping("selectSuperviseInfoByLike")
    @ApiOperation(value = "根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）", notes = "根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByLike(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByLike(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示
     * @return
     */
    @GetMapping("selectSuperviseInfoByRectify")
    @ApiOperation(value = "根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示", notes = "根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByRectify(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByRectify(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


}
