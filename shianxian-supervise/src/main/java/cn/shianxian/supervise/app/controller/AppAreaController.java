package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * app区域
 */
@RestController
@RequestMapping("app/area")
@Api(description = "app区域控制器")
public class AppAreaController {


    @Autowired
    private AreaService areaService;


    /**
     * 查询区域
     * @return
     */
    @PostMapping("selectAreaById")
    @ApiOperation(value = "查询区域", notes = "查询区域")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "parentId", value = "父id"),
    })
    public ResponseEntity<Result> selectArea(QueryPojo queryPojo) {
        Result result = this.areaService.selectArea(queryPojo);
        return ResponseEntity.ok(result);
    }


}
