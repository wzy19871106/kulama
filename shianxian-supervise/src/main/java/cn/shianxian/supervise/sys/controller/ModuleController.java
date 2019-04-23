package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiImplicitParam(paramType = "query", name = "id", value = "角色id")
    public ResponseEntity<Result> selectModule(String id) {
        Result result = this.moduleService.selectModule(id);
        return ResponseEntity.ok(result);
    }

}
