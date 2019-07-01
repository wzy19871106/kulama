package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.plan.service.SupervisePlanMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app计划任务控制器
 */
@RestController
@RequestMapping("app/spervisePlan")
@Api(description = "app计划任务控制器")
public class AppSupervisePlanController {


    @Autowired
    private SupervisePlanMainService supervisePlanMainService;


    /**
     * 根据节点id查询计划任务
     * @return
     */
    @PostMapping("selectSupervisePlanByNode")
    @ApiOperation(value = "根据节点id查询计划任务（根据企业编码初始化当前年度的计划任务列表）", notes = "根据节点id查询计划任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSupervisePlanByNode(String nodeTag, Pages pages) {
        Result result = this.supervisePlanMainService.selectSupervisePlanByNode(nodeTag, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 据子类型编码查询所有监管内容，按类型分组展示
     * @return
     */
    @PostMapping("selectSupervisePlanDetailByIds")
    @ApiOperation(value = "据子类型编码查询所有监管内容，按类型分组展示", notes = "据子类型编码查询所有监管内容，按类型分组展示")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "子类型编码")
    })
    public ResponseEntity<Result> selectSupervisePlanDetailByIds(String planTag, String nodeTag) {
        Result result = this.supervisePlanMainService.selectSupervisePlanDetailByIds(planTag, nodeTag);
        return ResponseEntity.ok(result);
    }

}
