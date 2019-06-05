package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.service.SuperviseInfoOldService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 线下监管信息控制器
 */
@RestController
@RequestMapping("superviseInfoOld")
@Api(description = "线下监管信息控制器")
@Slf4j
public class SuperviseInfoOldController {


    @Autowired
    private SuperviseInfoOldService superviseInfoOldService;


    /**
     * 导入线下监管信息
     * @return
     */
    @PostMapping("superviseInfoOld")
    @ApiOperation(value = "导入线下监管信息", notes = "导入线下监管信息")
    public ResponseEntity<Result> importSuperviseInfoOld(@ApiParam(value = "要上传的文件", required = true) MultipartFile file) throws IOException {
        log.info("导入线下监管信息");
        return this.superviseInfoOldService.importSuperviseInfoOld(file);
    }


    /**
     * 查询导入线下监管信息
     * @return
     */
    @GetMapping("superviseInfoOld")
    @ApiOperation(value = "查询导入线下监管信息", notes = "查询导入线下监管信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoOld(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoOldService.selectSuperviseInfoOld(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


}
