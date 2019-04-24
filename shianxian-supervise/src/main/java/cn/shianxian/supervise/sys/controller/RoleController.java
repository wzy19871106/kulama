package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Role;
import cn.shianxian.supervise.sys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("role")
@Api(description = "角色控制器")
public class RoleController {


    @Autowired
    private RoleService roleService;


    /**
     * 保存、修改角色
     * @return
     */
    @PostMapping("saveOrUpdateRole")
    @ApiOperation(value = "保存、修改角色接口", notes = "保存、修改角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roleTag", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "roleName", value = "角色名称"),
            @ApiImplicitParam(paramType = "query", name = "roleDisabled", value = "角色是否隐藏[1隐藏，0可见]"),
            @ApiImplicitParam(paramType = "query", name = "moduleAuthority", value = "模块权限JSON"),
    })
    public ResponseEntity<Result> saveOrUpdateRole(@Valid Role role) {
        Result result = this.roleService.saveOrUpdateRole(role);
        return ResponseEntity.ok(result);
    }


    /**
     * 分页查询角色
     * @return
     */
    @GetMapping("selectRoleByPage")
    @ApiOperation(value = "分页查询角色接口", notes = "分页查询角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
    })
    public ResponseEntity<Result> selectRoleByPage(QueryPojo queryPojo, Pages pages) {
        Result result = this.roleService.selectRoleByPage(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除角色
     * @return
     */
    @DeleteMapping("deleteRoleById")
    @ApiOperation(value = "删除角色接口", notes = "删除角色接口")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> deleteRoleById(String id) {
        Result result = this.roleService.deleteRoleById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 获取角色拥有的权限
     * @return
     */
    @GetMapping("selectAuthorityById")
    @ApiOperation(value = "获取角色拥有的权限接口", notes = "获取角色拥有的权限接口")
    @ApiImplicitParam(paramType = "query", name = "id", value = "角色id")
    public ResponseEntity<Result> selectAuthorityById(String id) {
        Result result = this.roleService.selectAuthorityById(id);
        return ResponseEntity.ok(result);
    }


}
