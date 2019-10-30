package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import cn.shianxian.supervise.info.service.SuperviseInfoMainTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 监管业务主类型控制器
 */
@RestController
@RequestMapping("superviseInfoMainType")
@Api(description = "监管业务主类型控制器")
@Slf4j
public class SuperviseInfoMainTypeController {


    @Autowired
    private SuperviseInfoMainTypeService superviseInfoMainTypeService;


    /**
     * 保存监管业务主类型
     * @return
     */
    @PostMapping("superviseInfoMainType")
    @ApiOperation(value = "保存监管业务主类型", notes = "保存监管业务主类型")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainIds", value = "监管业务(主类型)主键"),
            @ApiImplicitParam(paramType = "query", name = "parentMainIds", value = "监管业务(主类型)父ID"),
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务主键"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTeamName", value = "执法队伍名称"),
            @ApiImplicitParam(paramType = "query", name = "superviserTag", value = "执法人员编码"),
            @ApiImplicitParam(paramType = "query", name = "superviserName", value = "执法人员名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人编码"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "监管日期"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "结果分值"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "整改状态  0 无需整改 1,2,3,4.....需要整改的数量"),
            @ApiImplicitParam(paramType = "query", name = "ifVisit", value = "回访状态"),
            @ApiImplicitParam(paramType = "query", name = "ifOnline", value = "是否是线上监管"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除"),
    })
    public ResponseEntity<Result> saveSuperviseInfoMainType(@Valid SuperviseInfoMainType superviseInfoMainType) {
        log.info("保存监管业务主类型：{}", superviseInfoMainType);
        Result result = this.superviseInfoMainTypeService.saveSuperviseInfoMainType(superviseInfoMainType);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据主业务编码更新整改状态
     * @return
     */
    @PutMapping("superviseInfoMainType")
    @ApiOperation(value = "根据主业务编码更新整改状态", notes = "根据主业务编码更新整改状态")
    @ApiImplicitParam(paramType = "query", name = "mainIds", value = "监管业务(主类型)主键")
    public ResponseEntity<Result> updateSuperviseInfoMainType(String mainIds) {
        log.info("根据主业务编码更新整改状态：{}", mainIds);
        Result result = this.superviseInfoMainTypeService.updateSuperviseInfoMainType(mainIds);
        return ResponseEntity.ok(result);
    }


}
