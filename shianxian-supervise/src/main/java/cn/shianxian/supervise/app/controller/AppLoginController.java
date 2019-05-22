package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.service.FunctionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * app登录控制器
 */
@RestController
@Api(description = "app登录控制器")
public class AppLoginController {


    @Autowired
    private FunctionaryService functionaryService;


    /**
     * app登录
     * @return
     */
    @PostMapping("app/login")
    @ApiOperation(value = "app用户登录接口", notes = "app用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "微信appId"),
    })
    public ResponseEntity<Result> appLogin(@RequestParam() String id) {
        return this.functionaryService.appLogin(id);
    }

}
