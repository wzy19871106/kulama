package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@Api(description = "登录控制器")
public class LoginController {


    @Autowired
    private UserService userService;


    /**
     * 登录
     * @return
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录接口", notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码（MD5加密）"),
    })
    public ResponseEntity<Result> login(String username, String password) {
        Result result = this.userService.login(username, password);
        return ResponseEntity.ok(result);
    }

}
