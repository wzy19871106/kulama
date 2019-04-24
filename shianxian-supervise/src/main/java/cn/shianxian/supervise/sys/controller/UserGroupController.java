package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.UserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户组控制器
 */
@RestController
@RequestMapping("userGroup")
@Api(description = "用户组控制器")
public class UserGroupController {


    @Autowired
    private UserGroupService userGroupService;


    /**
     * 保存、修改用户组
     * @return
     */
    @PostMapping("saveOrUpdateUserGroup")
    @ApiOperation(value = "保存、修改用户组接口", notes = "保存、修改用户组接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userGroupTag", value = "数据权限标识"),
            @ApiImplicitParam(paramType = "query", name = "userParentTag", value = "父数据权限标识"),
            @ApiImplicitParam(paramType = "query", name = "userGroupName", value = "数据权限名称"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDisabled", value = "数据权限是否启用"),
            @ApiImplicitParam(paramType = "query", name = "userDataAuthority", value = "数据权限模板的维度模板"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "数据权限图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "数据权限流水号"),
    })
    public ResponseEntity<Result> saveOrUpdateUserGroup(@Valid UserGroup userGroup) {
        Result result = this.userGroupService.saveOrUpdateUserGroup(userGroup);
        return ResponseEntity.ok(result);
    }

}
