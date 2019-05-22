package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
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
 * app监管业务控制器
 */
@RestController
@RequestMapping("app/sperviseInfo")
@Api(description = "app监管业务控制器")
public class AppSuperviseInfoController {


    @Autowired
    private SuperviseInfoMainService superviseInfoMainService;


    /**
     * 根据节点id查询已完成的计划任务的监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByNodePlan")
    @ApiOperation(value = "根据节点id查询监管业务", notes = "根据节点id查询监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByNodePlan(String nodeTag, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByNodePlan(nodeTag, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据id查询已完成的计划任务的监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByIdPlan")
    @ApiOperation(value = "根据id查询已完成的计划任务的监管业务", notes = "根据id查询已完成的计划任务的监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByIdPlan(String id, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByIdPlan(id, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据节点id查询监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByNode")
    @ApiOperation(value = "根据节点id查询监管业务", notes = "根据节点id查询监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByNode(String nodeTag, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByNode(nodeTag, pages);
        return ResponseEntity.ok(result);
    }
}
