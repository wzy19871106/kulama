package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.pojo.Khda;
import cn.shianxian.supervise.tibetan.service.KhdaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户信息控制器
 */
@RestController
@RequestMapping("KhSelect")
@Api(description = "客户信息控制器")
public class KhdaController {

    @Autowired
    private KhdaService khdaService;

    @PostMapping("selectCustomerInfoByNameAndPass")
    @ApiOperation(value = "根据用户名和密码查询客户信息",notes = "根据用户名和密码查询客户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "khloginname",value = "登录用户名"),
            @ApiImplicitParam(paramType = "query",name = "khloginpass",value = "登录密码"),
            @ApiImplicitParam(paramType = "query", name = "khtype", value = "1 上家  2 下家  3 巡检"),
    })
    public ResponseEntity selectCustomerInfoByNameAndPass(Khda khda){
        Result result = this.khdaService.selectCustomerInfoByNameAndPass(khda);
        return ResponseEntity.ok(result);
    }
}
