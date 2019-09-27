package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import cn.shianxian.supervise.sys.service.SuperviseResultService;
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
 * 监管结果控制器
 */
@RestController
@RequestMapping("superviseResult")
@Api(description = "监管结果控制器")
@Slf4j
public class SuperviseResultController {


    @Autowired
    private SuperviseResultService superviseResultService;


    /**
     * 保存监管结果
     * @return
     */
    @PostMapping("saveSuperviseResult")
    @ApiOperation(value = "保存监管结果接口", notes = "保存监管结果接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管内容编码（外）"),
            @ApiImplicitParam(paramType = "query", name = "resultValue", value = "监管结果"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "排序"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "结果分值"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "advice", value = "整改意见,该结果单项的整改意见"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveSuperviseResult(@Valid SuperviseResult superviseResult) {
        log.info("保存监管结果：{}", superviseResult);
        return this.superviseResultService.saveSuperviseResult(superviseResult);
    }


    /**
     * 修改监管结果
     * @return
     */
    @PutMapping("updateSuperviseResult")
    @ApiOperation(value = "修改监管结果接口", notes = "修改监管结果接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管内容编码（外）"),
            @ApiImplicitParam(paramType = "query", name = "resultValue", value = "监管结果"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "排序"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "结果分值"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "advice", value = "整改意见,该结果单项的整改意见"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> updateSuperviseResult(@Valid SuperviseResult superviseResult) {
        log.info("修改监管结果：{}", superviseResult);
        Result result = this.superviseResultService.updateSuperviseResult(superviseResult);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除监管结果
     * @return
     */
    @DeleteMapping("deleteSuperviseResultById")
    @ApiOperation(value = "删除监管结果接口", notes = "删除监管结果接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSuperviseResultById(String ids) {
        log.info("删除监管结果：{}", ids);
        return this.superviseResultService.deleteSuperviseResultById(ids);
    }


    /**
     * 查询监管结果
     * @return
     */
    @GetMapping("selectSuperviseResult")
    @ApiOperation(value = "查询监管结果", notes = "查询监管结果")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管内容编码"),
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
    })
    public ResponseEntity<Result> selectSuperviseResult(SuperviseResult superviseResult) {
        Result result = this.superviseResultService.selectSuperviseResult(superviseResult);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改监管结果排序
     * @return
     */
    @PutMapping("updateSuperviseResultBySort")
    @ApiOperation(value = "修改监管结果排序接口", notes = "修改监管结果排序接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "排序结果[1:升序，2:降序]"),
    })
    public ResponseEntity<Result> updateSuperviseResultBySort(String id, int type) {
        log.info("修改监管结果排序：{}，排序内容[1:升序，2:降序]：{}", id, type);
        return this.superviseResultService.updateSuperviseResultBySort(id, type);
    }


    /**
     * 查询监管结果（树）
     * @return
     */
    @GetMapping("selectSuperviseResultTree")
    @ApiOperation(value = "查询监管结果（树）", notes = "查询监管结果（树）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "typeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
    })
    public ResponseEntity<Result> selectSuperviseResultTree(String typeTag, String authority) {
        Result result = this.superviseResultService.selectSuperviseResultTree(typeTag, authority);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询整改反馈监管结果（树）
     * @return
     */
    @GetMapping("selectSuperviseResultRectifyTree")
    @ApiOperation(value = "查询整改反馈监管结果（树）", notes = "查询整改反馈监管结果（树）")
    @ApiImplicitParam(paramType = "query", name = "mainIds", value = "监管类型编码")
    public ResponseEntity<Result> selectSuperviseResultRectifyTree(String mainIds) {
        Result result = this.superviseResultService.selectSuperviseResultRectifyTree(mainIds);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据监管内容编码查询满分的监管结果
     * @param superviseTag
     * @return
     */
    @GetMapping("selectSuperviseFullResultById")
    @ApiOperation(value = "查询满分的监管结果",notes = "查询满分的监管结果")
    @ApiImplicitParam(paramType = "query",name = "superviseTag",value = "监管内容编码")
    public ResponseEntity<Result> selectSuperviseFullResultById(String superviseTag){
        Result result = this.superviseResultService.selectSuperviseFullResultById(superviseTag);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据监管内容编码查询最低分的监管结果
     * @param superviseTag
     * @return
     */
    @GetMapping("selectSuperviseWorstResultById")
    @ApiOperation(value = "查询满分的监管结果",notes = "查询满分的监管结果")
    @ApiImplicitParam(paramType = "query",name = "superviseTag",value = "监管内容编码")
    public ResponseEntity<Result> selectSuperviseWorstResultById(String superviseTag){
        Result result = this.superviseResultService.selectSuperviseWorstResultById(superviseTag);
        return ResponseEntity.ok(result);
    }
}
