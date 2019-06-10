package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 地图
 */
@RestController
@RequestMapping("map")
@Api(description = "地图控制器")
public class MapController {


    @Autowired
    private RedisService redisService;


    /**
     * 根据企业id获取位置
     * @return
     */
    @GetMapping("site")
    @ApiOperation(value = "根据企业id获取位置", notes = "根据企业id获取位置")
    @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业id")
    public ResponseEntity<Result> selectSite(String nodeTag) {
        String site = this.redisService.get(nodeTag);
        return ResponseEntity.ok(Result.data(site));
    }


}
