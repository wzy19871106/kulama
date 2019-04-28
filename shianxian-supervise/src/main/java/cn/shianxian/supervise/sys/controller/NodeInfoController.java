package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.service.NodeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 节点控制器
 */
@RestController
@Api(description = "节点控制器")
public class NodeInfoController {


    @Autowired
    private NodeInfoService nodeInfoService;


    /**
     * 保存、修改节点
     * @return
     */
    @PostMapping("saveOrUpdateNodeInfo")
    @ApiOperation(value = "保存、修改节点", notes = "保存、修改节点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码（MD5加密）"),
    })
    public ResponseEntity<Result> saveOrUpdateNodeInfo(@Valid NodeInfo nodeInfo) {
        Result result = this.nodeInfoService.saveOrUpdateNodeInfo(nodeInfo);
        return ResponseEntity.ok(result);
    }

}
