package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.NodeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app节点控制器
 */
@RestController
@RequestMapping("app/nodeInfo")
@Api(description = "节点控制器")
@Slf4j
public class AppNodeInfoController {


    @Autowired
    private NodeInfoService nodeInfoService;


    /**
     * 校验key
     * @return
     */
    @PostMapping("checkKey")
    @ApiOperation(value = "校验key", notes = "校验key")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "key", value = "key"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信id"),
    })
    public ResponseEntity<Result> checkKey(String key, String weChatId) {
        log.info("激活key：{}，微信id：{}", key, weChatId);
        return this.nodeInfoService.checkKey(key, weChatId);
    }

}
