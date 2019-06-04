package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.service.InformationService;
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
 * app政企互动控制器
 */
@RestController
@RequestMapping("app/information")
@Api(description = "app政企互动控制器")
@Slf4j
public class AppInformationController {


    @Autowired
    private InformationService informationService;


    /**
     * 查询政企互动信息
     * @return
     */
    @PostMapping("information")
    @ApiOperation(value = "查询政企互动信息", notes = "查询政企互动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "栏目id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectInformation(QueryPojo queryPojo, Pages pages) {
        return this.informationService.selectInformation(queryPojo, pages);
    }


    /**
     * 根据id查询政企互动信息
     * @return
     */
    @PostMapping("selectInformationById")
    @ApiOperation(value = "根据id查询政企互动信息", notes = "根据id查询政企互动信息")
    @ApiImplicitParam(paramType = "query", name = "index", value = "政企互动标识")
    public ResponseEntity<Result> selectInformationById(String index) {
        return this.informationService.selectInformationById(index);
    }


}
