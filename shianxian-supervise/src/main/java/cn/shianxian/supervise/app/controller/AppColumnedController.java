package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.service.ColumnedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app栏目控制器
 */
@RestController
@RequestMapping("app/columned")
@Api(description = "app栏目控制器")
@Slf4j
public class AppColumnedController {


    @Autowired
    private ColumnedService columnedService;


    /**
     * 查询栏目信息
     * @return
     */
    @PostMapping("columned")
    @ApiOperation(value = "查询栏目信息", notes = "查询栏目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectColumned(String name, Pages pages) {
        return this.columnedService.selectColumned(name, pages);
    }


    /**
     * 根据id查询栏目信息
     * @return
     */
    @PostMapping("selectColumnedById")
    @ApiOperation(value = "根据id查询栏目信息", notes = "根据id查询栏目信息")
    @ApiImplicitParam(paramType = "query", name = "columnTag", value = "栏目标识")
    public ResponseEntity<Result> selectColumnedById(Long columnTag) {
        return this.columnedService.selectColumnedById(columnTag);
    }
}
