package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.service.JhMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 进货控制器
 */
@RestController
@RequestMapping("SpSelect")
@Api(description = "进货信息控制器")
public class JhMainController {

    @Autowired
    private JhMainService jhMainService;
    @GetMapping("selectPurchaseInfoByjhkhdm")
    @ApiOperation(value = "根据进货客户编码查询进货信息",notes = "根据进货客户编码查询进货信息")
    @ApiImplicitParam(paramType = "query",name = "jhkhdm",value = "进货客户编码")
    public ResponseEntity selectPurchaseInfoByjhkhdm(String jhkhdm){
        Result result = this.jhMainService.selectPurchaseInfoByjhkhdm(jhkhdm);
        return ResponseEntity.ok(result);
    }
}
