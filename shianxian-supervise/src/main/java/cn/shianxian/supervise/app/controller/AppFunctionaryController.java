package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.service.FunctionaryService;
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
 * APP企业负责人控制器
 */
@RestController
@RequestMapping("app/functionary")
@Api(description = "APP企业负责人控制器")
public class AppFunctionaryController {


    @Autowired
    private FunctionaryService functionaryService;


    /**
     * 保存企业负责人
     * @param functionary
     * @return
     */
    @PostMapping("functionary")
    @ApiOperation(value = "保存企业负责人", notes = "保存企业负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryNo", value = "负责人身份证号"),
            @ApiImplicitParam(paramType = "query", name = "functionaryType", value = "负责人类型，1管理，2普通"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "负责人图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "functionaryDisable", value = "负责人是否启用"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "激活KEY"),
            @ApiImplicitParam(paramType = "query", name = "keyUsed", value = "是否已经激活"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "所属企业名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryPostition", value = "负责人职位，无固定"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> saveFunctionary(@Valid Functionary functionary) {
        return this.functionaryService.saveFunctionary(functionary);
    }
}
