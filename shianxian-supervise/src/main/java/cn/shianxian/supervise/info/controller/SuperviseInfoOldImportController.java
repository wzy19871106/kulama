package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOldImport;
import cn.shianxian.supervise.info.service.SuperviseInfoOldImportService;
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

/**
 * 线下监管文件导入控制器
 */
@RestController
@RequestMapping("superviseInfoOldImport")
@Api(description = "线下监管文件导入控制器")
@Slf4j
public class SuperviseInfoOldImportController {


    @Autowired
    private SuperviseInfoOldImportService superviseInfoOldImportService;


    /**
     * 保存线下监管文件
     * @return
     */
    @PostMapping("superviseInfoOldImport")
    @ApiOperation(value = "保存线下监管文件", notes = "保存线下监管文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "fileName", value = "文件名"),
            @ApiImplicitParam(paramType = "query", name = "importTime", value = "导入时间"),
            @ApiImplicitParam(paramType = "query", name = "importResult", value = "导入结果 0为导入失败，1为导入成功"),
    })
    public ResponseEntity<Result> saveSuperviseInfoOldImport(SuperviseInfoOldImport superviseInfoOldImport) {
        log.info("保存线下监管文件：{}", superviseInfoOldImport);
        Result result = this.superviseInfoOldImportService.saveSuperviseInfoOldImport(superviseInfoOldImport);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据时间查询文件导入信息表
     * @return
     */
    @GetMapping("superviseInfoOldImport")
    @ApiOperation(value = "根据时间查询文件导入信息表", notes = "根据时间查询文件导入信息表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoOldImport(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoOldImportService.selectSuperviseInfoOldImport(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


}
