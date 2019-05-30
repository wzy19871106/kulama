package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 监管类型控制器
 */
@RestController
@RequestMapping("superviseType")
@Api(description = "监管类型控制器")
@Slf4j
public class SuperviseTypeController {


    @Autowired
    private SuperviseTypeService superviseTypeService;


    /**
     * 保存、修改监管类型
     * @return
     */
    @PostMapping("saveOrUpdateSuperviseType")
    @ApiOperation(value = "保存、修改监管类型接口", notes = "保存、修改监管类型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "parentTag", value = "父类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeName", value = "监管类型名"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "监管类型位置"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDataAuthority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "ifMenu", value = "是否可以为该栏目添加信息", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "栏目禁用，不可添加新信息，历史数据不可查", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveOrUpdateSuperviseType(@Valid SuperviseType superviseType) {
        log.info("保存、修改监管类型：{}", superviseType);
        Result result = this.superviseTypeService.saveOrUpdateSuperviseType(superviseType);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除监管类型
     * @return
     */
    @DeleteMapping("deleteSuperviseTypeById")
    @ApiOperation(value = "删除监管类型接口", notes = "删除监管类型接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSuperviseTypeById(String ids) {
        log.info("删除监管类型：{}", ids);
        return this.superviseTypeService.deleteSuperviseTypeById(ids);
    }


    /**
     * 查询监管类型
     * @return
     */
    @GetMapping("selectSuperviseType")
    @ApiOperation(value = "查询监管类型", notes = "查询监管类型")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDataAuthority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
    })
    public ResponseEntity<Result> selectSuperviseType(SuperviseType superviseType) {
        Result result = this.superviseTypeService.selectSuperviseType(superviseType);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改监管类型排序
     * @return
     */
    @PutMapping("updateSuperviseTypeBySort")
    @ApiOperation(value = "修改监管类型排序接口", notes = "修改监管类型排序接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "排序类型[1:升序，2:降序]"),
    })
    public ResponseEntity<Result> updateSuperviseTypeBySort(String id, int type) {
        log.info("修改监管类型排序：{}，排序内容[1:升序，2:降序]：{}", id, type);
        Result result = this.superviseTypeService.updateSuperviseTypeBySort(id, type);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询监管类型（树形）
     * @return
     */
    @GetMapping("selectSuperviseTypeTree")
    @ApiOperation(value = "查询监管类型（树形）", notes = "查询监管类型（树形）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDataAuthority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
    })
    public ResponseEntity<Result> selectSuperviseTypeTree(SuperviseType superviseType) {
        Result result = this.superviseTypeService.selectSuperviseTypeTree(superviseType);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据id查询监管类型
     * @return
     */
    @GetMapping("selectSuperviseTypeById")
    @ApiOperation(value = "根据id查询监管类型", notes = "根据id查询监管类型")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型编码")
    public ResponseEntity<Result> selectSuperviseTypeById(String id) {
        Result result = this.superviseTypeService.selectSuperviseTypeById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存、修改监管类型权限
     * @return
     */
    @PutMapping("superviseTypeAuthority")
    @ApiOperation(value = "保存、修改监管类型权限", notes = "保存、修改监管类型权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "userGroupDataAuthority", value = "哪些数据权限模板拥有该监管类型的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "类型[1:新增权限，2:修改权限]"),
    })
    public ResponseEntity<Result> superviseTypeAuthority(SuperviseType superviseType, int type) {
        log.info("保存、修改监管类型权限：{}，类型[1:新增权限，2:修改权限]：{}", superviseType, type);
        Result result = this.superviseTypeService.superviseTypeAuthority(superviseType, type);
        return ResponseEntity.ok(result);
    }
}
