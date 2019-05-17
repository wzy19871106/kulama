package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import cn.shianxian.supervise.sys.service.SuperviseResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
        Result result = this.superviseResultService.saveSuperviseResult(superviseResult);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改监管结果
     * @return
     */
    @PostMapping("updateSuperviseResult")
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
        return this.superviseResultService.deleteSuperviseResultById(ids);
    }


    /**
     * 查询监管结果
     * @return
     */
    @GetMapping("selectSuperviseResult")
    @ApiOperation(value = "查询监管结果", notes = "查询监管结果")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管内容编码"),
    })
    public ResponseEntity<Result> selectSuperviseResult(SuperviseResult superviseResult, Pages pages) {
        Result result = this.superviseResultService.selectSuperviseResult(superviseResult, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据监管类型返回所有监管选项结果
     * @return
     */
    @GetMapping("selectSuperviseResultByTypeId")
    @ApiOperation(value = "根据监管类型返回所有监管选项结果", notes = "根据监管类型返回所有监管选项结果")
    @ApiImplicitParam(paramType = "query", name = "typeId", value = "监管结果编码")
    public ResponseEntity<Result> selectSuperviseResultByTypeId(String typeId) {
        Result result = this.superviseResultService.selectSuperviseResultByTypeId(typeId);
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
        Result result = this.superviseResultService.updateSuperviseResultBySort(id, type);
        return ResponseEntity.ok(result);
    }


}
