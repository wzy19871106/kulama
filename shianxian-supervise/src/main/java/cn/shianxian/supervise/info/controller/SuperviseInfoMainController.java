package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
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

import javax.validation.Valid;

/**
 * 监管业务（主表）控制器
 */
@RestController
@RequestMapping("sperviseInfoMain")
@Api(description = "监管业务（主表）控制器")
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
        Result result = this.superviseInfoMainService.saveSuperviseInfoMain(superviseInfoMain);
        return ResponseEntity.ok(result);
    }

}
