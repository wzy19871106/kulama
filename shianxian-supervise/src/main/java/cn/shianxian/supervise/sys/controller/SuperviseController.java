package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Supervise;
import cn.shianxian.supervise.sys.service.SuperviseService;
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
 * 监管内容控制器
 */
@RestController
@RequestMapping("supervise")
@Api(description = "监管内容控制器")
@Slf4j
public class SuperviseController {


    @Autowired
    private SuperviseService superviseService;


    /**
     * 保存、修改监管内容
     * @return
     */
    @PostMapping("saveOrUpdateSupervise")
    @ApiOperation(value = "保存、修改监管内容接口", notes = "保存、修改监管内容接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管项目编码"),
            @ApiImplicitParam(paramType = "query", name = "parentTag", value = "父内容编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseName", value = "检查内容"),
            @ApiImplicitParam(paramType = "query", name = "superviseBasis", value = "检查依据"),
            @ApiImplicitParam(paramType = "query", name = "superviseMode", value = "检查方式"),
            @ApiImplicitParam(paramType = "query", name = "superviseGuide", value = "检查指南"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "模块位置，4位以上数字"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "监管项目分值"),
            @ApiImplicitParam(paramType = "query", name = "ifMenu", value = "是否可以添加监管结果信息", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "栏目启用，可添加信息，可查历史数据；栏目禁用，不可添加新信息，但历史数据可以查询", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "栏目禁用，不可添加新信息，历史数据不可查(逻辑删除)", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveOrUpdateSupervise(@Valid Supervise supervise) {
        log.info("保存、修改监管内容：{}", supervise);
        Result result = this.superviseService.saveOrUpdateSupervise(supervise);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除监管内容
     * @return
     */
    @DeleteMapping("deleteSuperviseById")
    @ApiOperation(value = "删除监管内容接口", notes = "删除监管内容接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSuperviseById(String ids) {
        log.info("删除监管内容：{}", ids);
        return this.superviseService.deleteSuperviseById(ids);
    }


    /**
     * 查询监管内容
     * @return
     */
    @GetMapping("selectSupervise")
    @ApiOperation(value = "查询监管内容", notes = "查询监管内容")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管项目编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
    })
    public ResponseEntity<Result> selectSupervise(Supervise supervise) {
        Result result = this.superviseService.selectSupervise(supervise);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改监管内容排序
     * @return
     */
    @PutMapping("updateSuperviseBySort")
    @ApiOperation(value = "修改监管内容排序接口", notes = "修改监管内容排序接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管内容编码"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "排序内容[1:升序，2:降序]"),
    })
    public ResponseEntity<Result> updateSuperviseBySort(String id, int type) {
        log.info("修改监管内容排序：{}，排序内容[1:升序，2:降序]：{}", id, type);
        Result result = this.superviseService.updateSuperviseBySort(id, type);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询监管内容剩余分值
     * @return
     */
    @GetMapping("selectSuperviseScore")
    @ApiOperation(value = "查询监管内容剩余分值", notes = "查询监管内容剩余分值")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管内容编码")
    public ResponseEntity<Result> selectSuperviseScore(String id) {
        Result result = this.superviseService.selectSuperviseScore(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据类型查询监管内容（树形）
     * @return
     */
    @GetMapping("selectSuperviseTree")
    @ApiOperation(value = "根据类型查询监管内容（树形）", notes = "根据类型查询监管内容（树形）")
    @ApiImplicitParam(paramType = "query", name = "type", value = "监管类型编码")
    public ResponseEntity<Result> selectSuperviseTree(String type) {
        Result result = this.superviseService.selectSuperviseTree(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据类型查询所有监管内容（树形）
     * @return
     */
    @GetMapping("selectSuperviseAllTree")
    @ApiOperation(value = "根据类型查询所有监管内容（树形）", notes = "根据类型查询所有监管内容（树形）")
    @ApiImplicitParam(paramType = "query", name = "type", value = "监管类型编码")
    public ResponseEntity<Result> selectSuperviseAllTree(String type) {
        Result result = this.superviseService.selectSuperviseAllTree(type);
        return ResponseEntity.ok(result);
    }


}
