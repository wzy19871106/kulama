package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.RoleAuthority;
import cn.shianxian.supervise.sys.service.RoleAuthorityService;
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
 * 角色权限控制器
 */
@RestController
@RequestMapping("roleAuthority")
@Api(description = "角色权限控制器")
public class RoleAuthorityController {


    @Autowired
    private RoleAuthorityService roleAuthorityService;


    /**
     * 设置角色权限
     * @return
     */
    @PostMapping("saveRoleAuthority")
    @ApiOperation(value = "设置角色权限接口", notes = "设置角色权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "角色标识"),
            @ApiImplicitParam(paramType = "query", name = "authoritys", value = "权限id"),
            @ApiImplicitParam(paramType = "query", name = "modules", value = "模块id"),
    })
    public ResponseEntity<Result> saveRoleAuthority(RoleAuthority roleAuthority) {
        Result result = this.roleAuthorityService.saveRoleAuthority(roleAuthority);
        return ResponseEntity.ok(result);
    }
}
