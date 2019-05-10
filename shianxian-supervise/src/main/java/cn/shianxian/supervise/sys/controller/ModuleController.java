package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Module;
import cn.shianxian.supervise.sys.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 模块控制器
 */
@RestController
@RequestMapping("module")
@Api(description = "模块控制器")
public class ModuleController {


    @Autowired
    private ModuleService moduleService;


    /**
     * 查询模块
     * @return
     */
    @GetMapping("selectModule")
    @ApiOperation(value = "查询模块接口", notes = "查询模块接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "parentId", value = "父id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectModule(QueryPojo queryPojo, Pages pages) {
        Result result = this.moduleService.selectModule(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 校验模块位置是否存在
     * @return
     */
    @GetMapping("checkModule")
    @ApiOperation(value = "校验模块位置是否存在", notes = "校验模块位置是否存在")
    @ApiImplicitParams({
          @ApiImplicitParam(paramType = "query", name = "moduleTag", value = "模块标识"),
          @ApiImplicitParam(paramType = "query", name = "moduleUrl", value = "模块位置"),
    })
    public ResponseEntity<Result> checkModule(Module module) {
        Result result = this.moduleService.checkModule(module);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存、修改模块
     * @return
     */
    @PostMapping("saveOrUpdateModule")
    @ApiOperation(value = "保存、修改模块", notes = "保存、修改模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "moduleTag", value = "模块标识"),
            @ApiImplicitParam(paramType = "query", name = "parentTag", value = "父模块标识编号"),
            @ApiImplicitParam(paramType = "query", name = "moduleName", value = "模块名称"),
            @ApiImplicitParam(paramType = "query", name = "moduleIcon", value = "图标"),
            @ApiImplicitParam(paramType = "query", name = "moduleUrl", value = "模块位置"),
            @ApiImplicitParam(paramType = "query", name = "moduleDisabled", value = "模块是否隐藏"),
            @ApiImplicitParam(paramType = "query", name = "order", value = "模块位置，6位以上数字"),
            @ApiImplicitParam(paramType = "query", name = "moduleDescription", value = "模块摘要"),
            @ApiImplicitParam(paramType = "query", name = "ifMenu", value = "是否目录"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "模块流水号"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "模块流水号"),
    })
    public ResponseEntity<Result> saveOrUpdateModule(@Valid Module module) {
        Result result = this.moduleService.saveOrUpdateModule(module);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除模块
     * @return
     */
    @DeleteMapping("deleteModuleById")
    @ApiOperation(value = "删除模块", notes = "删除模块")
    @ApiImplicitParam(paramType = "query", name = "id", value = "模块标识")
    public ResponseEntity<Result> deleteModuleById(String id) {
        Result result = this.moduleService.deleteModuleById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询模块（根据树形排序数据）
     * @return
     */
    @GetMapping("selectModuleByTree")
    @ApiOperation(value = "查询模块（根据树形排序数据）", notes = "查询模块（根据树形排序数据）")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> selectModuleByTree(String id) {
        Result result = this.moduleService.selectModuleByTree(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询模块（树形）
     * @return
     */
    @GetMapping("selectModuleTree")
    @ApiOperation(value = "查询模块（树形）", notes = "查询模块（树形）")
    public ResponseEntity<Result> selectModuleTree() {
        Result result = this.moduleService.selectModuleTree();
        return ResponseEntity.ok(result);
    }

}
