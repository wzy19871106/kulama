package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 监管类型控制器
 */
@RestController
@RequestMapping("supervisetype")
@Api(description = "角色控制器")
public class SupervisetypeController {


    @Autowired
    private SuperviseTypeService superviseTypeService;


    /**
     * 保存、修改监管类型控制器
     * @return
     */
    @PostMapping("saveOrUpdateSupervisetype")
    @ApiOperation(value = "保存、修改监管类型控制器接口", notes = "保存、修改监管类型控制器接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "parentTag", value = "父类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeName", value = "监管类型名"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "监管类型位置"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDataAuthority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "ifMenu", value = "是否可以为该栏目添加信息"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "栏目禁用，不可添加新信息，历史数据不可查"),
    })
    public ResponseEntity<Result> saveOrUpdateSupervisetype(@Valid SuperviseType superviseType) {
        Result result = this.superviseTypeService.saveOrUpdateSuperviseType(superviseType);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除监管类型
     * @return
     */
    @DeleteMapping("deleteSuperviseTypeById")
    @ApiOperation(value = "删除监管类型接口", notes = "删除监管类型接口")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> deleteSuperviseTypeById(String id) {
        Result result = this.superviseTypeService.deleteSuperviseTypeById(id);
        return ResponseEntity.ok(result);
    }



}
