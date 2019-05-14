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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色权限权限控制器
 */
@RestController
@RequestMapping("roleAuthority")
@Api(description = "角色权限权限控制器")
public class RoleAuthorityController {


    @Autowired
    private RoleAuthorityService roleAuthorityService;

    /**
     * 保存角色权限
     * @return
     */
    @PostMapping("saveRoleAuthority")
    @ApiOperation(value = "保存角色权限接口", notes = "保存角色权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "角色标识"),
            @ApiImplicitParam(paramType = "query", name = "moduleAuthority", value = "模块权限(JSON格式)"),
    })
    public ResponseEntity<Result> saveRoleAuthority(@Valid RoleAuthority roleAuthority) {
        Result result = this.roleAuthorityService.saveRoleAuthority(roleAuthority);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改角色权限
     * @return
     */
    @PutMapping("updateRoleAuthority")
    @ApiOperation(value = "修改角色权限", notes = "修改角色权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "角色标识"),
            @ApiImplicitParam(paramType = "query", name = "moduleAuthority", value = "模块权限(JSON格式)"),
    })
    public ResponseEntity<Result> updateRoleAuthority(@Valid RoleAuthority roleAuthority) {
        Result result = this.roleAuthorityService.updateRoleAuthority(roleAuthority);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除角色权限
     * @return
     */
    @DeleteMapping("deleteRoleAuthorityById")
    @ApiOperation(value = "删除角色权限接口", notes = "删除角色权限接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids")
    public ResponseEntity<Result> deleteRodeleteRoleAuthorityByIdleById(String ids) {
        Result result = this.roleAuthorityService.deleteRoleAuthorityById(ids);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据角色id查询权限
     * @return
     */
    @GetMapping("selectAuthorityByRoleId")
    @ApiOperation(value = "根据角色id查询权限", notes = "根据角色id查询权限")
    public ResponseEntity<Result> selectAuthorityByRoleId(String id) {
        Result result = this.roleAuthorityService.selectAuthorityByRoleId(id);
        return ResponseEntity.ok(result);
    }

}
