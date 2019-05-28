package cn.shianxian.supervise.plan.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.pojo.SupervisePlanMain;
import cn.shianxian.supervise.plan.service.SupervisePlanMainService;
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
 * 计划任务控制器
 */
@RestController
@RequestMapping("spervisePlanMain")
@Api(description = "计划任务控制器")
@Slf4j
public class SupervisePlanMainController {


    @Autowired
    private SupervisePlanMainService supervisePlanMainService;


    /**
     * 保存、修改计划任务
     * @return
     */
    @PostMapping("saveOrUpdateSupervisePlanMain")
    @ApiOperation(value = "保存、修改计划任务接口", notes = "保存、修改计划任务接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务编号"),
            @ApiImplicitParam(paramType = "query", name = "planName", value = "计划任务名称"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "ifPulic", value = "是否公开", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveOrUpdateSupervisePlanMain(@Valid SupervisePlanMain supervisePlanMain) {
        log.info("保存、修改计划任务：{}", supervisePlanMain);
        Result result = this.supervisePlanMainService.saveOrUpdateSupervisePlanMain(supervisePlanMain);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除计划任务
     * @return
     */
    @DeleteMapping("deleteSupervisePlanMainById")
    @ApiOperation(value = "删除计划任务接口", notes = "删除计划任务接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSupervisePlanMainById(String ids) {
        log.info("删除计划任务：{}", ids);
        Result result = this.supervisePlanMainService.deleteSupervisePlanMainById(ids);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询计划任务
     * @return
     */
    @GetMapping("selectSupervisePlanMain")
    @ApiOperation(value = "查询计划任务", notes = "查询计划任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSupervisePlanMain(QueryPojo queryPojo, Pages pages) {
        Result result = this.supervisePlanMainService.selectSupervisePlanMain(queryPojo, pages);
        return ResponseEntity.ok(result);
    }

}
