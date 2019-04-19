package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.UserService;
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
 * 用户控制器
 */
@RestController
@RequestMapping("user")
@Api(description = "用户控制器")
public class UserController {


    @Autowired
    private UserService userService;


    /**
     * 分页查询用户
     * @return
     */
    @GetMapping("selectUserByPage")
    @ApiOperation(value = "分页查询用户接口", notes = "分页查询用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "orderNo", value = "单号"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "enable", value = "是否有效，1：有效0：无效。"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectUserByPage(QueryPojo queryPojo, Pages pages) {
        Result result = this.userService.selectUserByPage(queryPojo, pages);
        return ResponseEntity.ok(result);
    }

}
