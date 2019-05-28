package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
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
 * 监管业务（从表）控制器
 */
@RestController
@RequestMapping("sperviseInfoSub")
@Api(description = "监管业务（从表）控制器")
@Slf4j
public class SuperviseInfoSubController {


    @Autowired
    private SuperviseInfoSubService superviseInfoSubService;


    /**
     * 根据监管编码返回待整改的监管内容的整改意见
     * @return
     */
    @GetMapping("selectSuperviseInfoAdviceById")
    @ApiOperation(value = "根据监管编码返回待整改的监管内容的整改意见", notes = "根据监管编码返回待整改的监管内容的整改意见")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管编码")
    public ResponseEntity<Result> selectSuperviseInfoAdviceById(String id) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoAdviceById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存监管业务（从表）
     * @return
     */
    @PostMapping("superviseInfoSub")
    @ApiOperation(value = "保存监管业务（从表）", notes = "保存监管业务（从表）")
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
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "整改状态  0 无需整改 1，整改完成 2，待整改，3 整改提交，待审核4……"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
    })
    public ResponseEntity<Result> saveSuperviseInfoSub(@Valid SuperviseInfoSub superviseInfoSub) {
        log.info("保存监管业务（从表）：{}", superviseInfoSub);
        Result result = this.superviseInfoSubService.saveSuperviseInfoSub(superviseInfoSub);
        return ResponseEntity.ok(result);
    }
}
