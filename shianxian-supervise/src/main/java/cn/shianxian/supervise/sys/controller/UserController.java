package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.exception.CommonException;
import cn.shianxian.supervise.sys.pojo.User;
import cn.shianxian.supervise.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            @ApiImplicitParam(paramType = "query", name = "userTag", value = "用户标识"),
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户姓名"),
            @ApiImplicitParam(paramType = "query", name = "userGroupTag", value = "所属数据权限模板标识"),
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "所属用户角色标识"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectUserByPage(User user, Pages pages) {
        Result result = this.userService.selectUserByPage(user, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改密码
     * @return
     */
    @PostMapping("updatePassword")
    @ApiOperation(value = "修改密码接口", notes = "修改密码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码"),
            @ApiImplicitParam(paramType = "query", name = "confirmPassword", value = "确认密码"),
    })
    public ResponseEntity<Result> updatePassword(String id, String password, String confirmPassword) {
        if (StringUtils.isAnyBlank(id, password, confirmPassword)) {
            throw new CommonException(Constants.BAD_REQUEST, "缺少参数！");
        }
        if (!password.equals(confirmPassword)) {
            throw new CommonException(Constants.FORBIDDEN, "两次密码不一致！");
        }
        Result result = this.userService.updatePassword(id, password);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存、修改用户
     * @return
     */
    @PostMapping("saveOrUpdateUser")
    @ApiOperation(value = "保存、修改用户接口", notes = "保存、修改用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userTag", value = "用户标识"),
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户姓名"),
            @ApiImplicitParam(paramType = "query", name = "userNo", value = "用户身份证号"),
            @ApiImplicitParam(paramType = "query", name = "userTel", value = "用户联系电话"),
            @ApiImplicitParam(paramType = "query", name = "userLoginName", value = "用户登录名"),
            @ApiImplicitParam(paramType = "query", name = "userLoginPass", value = "用户登录密码"),
            @ApiImplicitParam(paramType = "query", name = "userGroupTag", value = "所属数据权限模板标识"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "用户图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "userDisabled", value = "用户是否启用"),
            @ApiImplicitParam(paramType = "query", name = "userLastTime", value = "用户最后登陆时间"),
            @ApiImplicitParam(paramType = "query", name = "userErrCount", value = "用户错误次数"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "用户流水号"),
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "所属用户角色标识"),
    })
    public ResponseEntity<Result> saveOrUpdateUser(@Valid User user) {
        Result result = this.userService.saveOrUpdateUser(user);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除用户
     * @return
     */
    @DeleteMapping("deleteUserById")
    @ApiOperation(value = "删除用户接口", notes = "删除用户接口")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> deleteUserById(String id) {
        Result result = this.userService.deleteUserById(id);
        return ResponseEntity.ok(result);
    }
}
