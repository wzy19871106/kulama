package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app获取版本号
 */

@RestController
@RequestMapping("app/version")
@Api(description = "app版本获取控制器")
@Slf4j
public class AppVersionController {

    @Autowired
    private AppVersionService appVersionService;

    /**
     * 根据id查询app版本号
     * @param id
     * @return
     */
    @GetMapping("selectAppVersionById")
    @ApiOperation(value = "根据id查询app版本号",notes = "根据id查询app版本号")
    @ApiImplicitParam(paramType = "query", name = "id", value = "app版本号id")
    public ResponseEntity<Result> selectAppVersionById(int id){
        Result result = this.appVersionService.selectAppVersion(id);
        return ResponseEntity.ok(Result.data(result));
    }

}
