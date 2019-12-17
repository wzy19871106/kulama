package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 区域
 */
@RestController
@RequestMapping("area")
@Api(description = "区域控制器")
public class AreaController {


    @Autowired
    private AreaService areaService;


    /**
     * 查询区域
     * @return
     */
    @GetMapping("selectAreaById")
    @ApiOperation(value = "查询区域", notes = "查询区域")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "parentId", value = "父id"),
    })
    public ResponseEntity<Result> selectArea(QueryPojo queryPojo) {
        Result result = this.areaService.selectArea(queryPojo);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询区域
     * @return
     */
    @GetMapping("selectCompositionArea")
    @ApiOperation(value = "查询树形区域", notes = "查询树形区域")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "areaTag", value = "areaTag")
    })
    public ResponseEntity<Result> selectCompositionArea(String areaTag) {
        Result result = this.areaService.selectCompositionArea(areaTag);
        return ResponseEntity.ok(result);
    }

}
