package cn.shianxian.supervise.government.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.pojo.Columned;
import cn.shianxian.supervise.government.service.ColumnedService;
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
 * 栏目控制器
 */
@RestController
@RequestMapping("columned")
@Api(description = "栏目控制器")
@Slf4j
public class ColumnedController {


    @Autowired
    private ColumnedService columnedService;


    /**
     * 保存、修改栏目信息
     *
     * @return
     */
    @PostMapping("columned")
    @ApiOperation(value = "保存、修改栏目信息", notes = "保存、修改栏目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "columnTag", value = "栏目标识"),
            @ApiImplicitParam(paramType = "query", name = "columnName", value = "栏目名称"),
            @ApiImplicitParam(paramType = "query", name = "columnDisable", value = "是否启用"),
    })
    public ResponseEntity<Result> saveOrUpdateColumned(@Valid Columned columned) {
        log.info("保存、修改栏目信息：{}", columned);
        return this.columnedService.saveOrUpdateColumned(columned);
    }


    /**
     * 删除栏目信息
     *
     * @return
     */
    @DeleteMapping("columned")
    @ApiOperation(value = "删除栏目信息", notes = "删除栏目信息")
    @ApiImplicitParam(paramType = "query", name = "columnTag", value = "栏目标识")
    public ResponseEntity<Result> deleteColumned(@RequestParam Long columnTag) {
        log.info("删除栏目信息", columnTag);
        return this.columnedService.deleteColumned(columnTag);
    }

    
    /**
     * 查询栏目信息
     * @return
     */
    @GetMapping("columned")
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
    @GetMapping("selectColumnedById")
    @ApiOperation(value = "根据id查询栏目信息", notes = "根据id查询栏目信息")
    @ApiImplicitParam(paramType = "query", name = "columnTag", value = "栏目标识")
    public ResponseEntity<Result> selectColumnedById(Long columnTag) {
        return this.columnedService.selectColumnedById(columnTag);
    }
}
