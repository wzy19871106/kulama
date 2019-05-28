package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSubOld;
import cn.shianxian.supervise.info.service.SuperviseInfoSubOldService;
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
 * 线下监管业务（从表）控制器
 */
@RestController
@RequestMapping("superviseInfoMainOld")
@Api(description = "线下监管业务（从表）控制器")
@Slf4j
public class SuperviseInfoSubOldController {


    @Autowired
    private SuperviseInfoSubOldService superviseInfoSubOldService;


    /**
     * 根据所选监管业务编码和监管类型查询监管结果详细信息
     * @return
     */
    @GetMapping("selectSuperviseInfoOldDetail")
    @ApiOperation(value = "根据所选监管业务编码和监管类型查询监管结果详细信息", notes = "根据所选监管业务编码和监管类型查询监管结果详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
    })
    public ResponseEntity<Result> selectSuperviseInfoOldDetail(SuperviseInfoSubOld superviseInfoSubOld) {
        Result result = this.superviseInfoSubOldService.selectSuperviseInfoOldDetail(superviseInfoSubOld);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存线下监管业务从表
     * @return
     */
    @PostMapping("superviseInfoSubOld")
    @ApiOperation(value = "保存线下监管业务从表", notes = "保存线下监管业务从表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "subId", value = "监管业务主键"),
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "主表外键"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管项目编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseName", value = "监管内容详细"),
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "resultValue", value = "监管结果值"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "结果分值"),
            @ApiImplicitParam(paramType = "query", name = "advice", value = "整改意见"),
            @ApiImplicitParam(paramType = "query", name = "requst", value = "整改反馈"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "附件路径"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "整改状态  0 无需整改 1，整改完成 2，待整改，3 整改提交，待审核4……"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
    })
    public ResponseEntity<Result> saveSuperviseInfoSubOld(@Valid SuperviseInfoSubOld superviseInfoSubOld) {
        log.info("保存线下监管业务（从表）：{}", superviseInfoSubOld);
        Result result = this.superviseInfoSubOldService.saveSuperviseInfoSubOld(superviseInfoSubOld);
        return ResponseEntity.ok(result);
    }

}