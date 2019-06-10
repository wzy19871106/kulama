package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.service.RedisService;
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
 * app地图
 */
@RestController
@RequestMapping("app/map")
@Api(description = "app地图控制器")
public class AppMapController {


    @Autowired
    private RedisService redisService;


    /**
     * 保存位置
     * @return
     */
    @PostMapping("site")
    @ApiOperation(value = "保存位置", notes = "保存位置")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业id"),
            @ApiImplicitParam(paramType = "query", name = "site", value = "位置"),
    })
    public ResponseEntity<Result> saveSite(String nodeTag, String site) {
        this.redisService.set(nodeTag, site, 3600);
        return ResponseEntity.ok(Result.successMsg());
    }


}
