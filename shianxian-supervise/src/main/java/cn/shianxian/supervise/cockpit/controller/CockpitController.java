package cn.shianxian.supervise.cockpit.controller;

import cn.shianxian.supervise.cockpit.service.CockpitAssessService;
import cn.shianxian.supervise.cockpit.service.CockpitMapService;
import cn.shianxian.supervise.cockpit.service.CockpitPlanTaskService;
import cn.shianxian.supervise.cockpit.service.HotpointService;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 驾驶舱控制器
 */
@RestController
@RequestMapping("cockpit")
@Api(description = "驾驶舱控制器")
@Slf4j
public class CockpitController {

    @Autowired
    private HotpointService hotpointService;
    @Autowired
    private CockpitMapService cockpitMapService;
    @Autowired
    private CockpitPlanTaskService cockpitPlanTaskService;
    @Autowired
    private CockpitAssessService cockpitAssessService;

    /**
     * 查询所有监管类型
     *
     * @return
     */
    @GetMapping("selectAllSuperviseType")
    @ApiOperation(value = "查询所有监管类型", notes = "查询所有监管类型")
    public ResponseEntity<Result> selectAllSuperviseType() {
        return this.hotpointService.selectAllSuperviseType();
    }

    /**
     * 查询所有区县
     *
     * @return
     */
    @GetMapping("selectAllArea")
    @ApiOperation(value = "查询所有区县", notes = "查询所有区县")
    public ResponseEntity<Result> selectAllArea() {
        return this.hotpointService.selectAllArea();
    }

    /**
     * 查询热点图
     *
     * @return
     */
    @GetMapping("selectHotpoint")
    @ApiOperation(value = "查询热点图", notes = "查询热点图")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码")
    })
    public ResponseEntity<Result> selectHotpoint(String superviseTypeTag) {
        return this.hotpointService.selectHotpoint(superviseTypeTag);
    }

    /**
     * 查询驾驶舱数据（含地图）
     *
     * @return
     */
    @GetMapping("selectCockpitMap")
    @ApiOperation(value = "查询驾驶舱数据（含地图）", notes = "查询驾驶舱数据（含地图）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "period", value = "考核周期")
    })
    public ResponseEntity<Result> selectCockpitMap(QueryPojo queryPojo) {
        return this.cockpitMapService.selectCockpitMap(queryPojo);
    }

    /**
     * 查询计划任务完成情况
     *
     * @return
     */
    @GetMapping("selectCockpitPlan")
    @ApiOperation(value = "查询计划任务完成情况", notes = "查询计划任务完成情况")
    public ResponseEntity<Result> selectCockpitPlan() {
        return this.cockpitPlanTaskService.selectCockpitPlan();
    }

    /**
     * 查询考核评议
     *
     * @return
     */
    @GetMapping("selectCockpitAssess")
    @ApiOperation(value = "查询考核评议", notes = "查询考核评议")
    public ResponseEntity<Result> selectCockpitAssess() {
        return this.cockpitAssessService.selectCockpitAssess();
    }

}
