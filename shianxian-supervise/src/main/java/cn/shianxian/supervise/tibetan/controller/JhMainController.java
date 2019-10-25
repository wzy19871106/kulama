package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.service.JhMainService;
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
 * 进货控制器
 */
@RestController
@RequestMapping("app/JhSelect")
@Api(description = "进货信息控制器")
public class JhMainController {

    @Autowired
    private JhMainService jhMainService;

    /**
     * 根据进货客户编码查询进货批次号 2
     * @param jhkhdm
     * @return
     */
    @PostMapping("selectPurchaseDmByjhkhdm")
    @ApiOperation(value = "根据进货客户编码查询进货批次号",notes = "根据进货客户编码查询进货批次号")
    @ApiImplicitParam(paramType = "query",name = "jhkhdm",value = "进货客户编码")
    public ResponseEntity selectPurchaseInfoByjhkhdm(String jhkhdm){
        Result result = this.jhMainService.selectPurchaseDmByjhkhdm(jhkhdm);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据进货客户编码和进货批次号查询进货信息，并排序 3
     * @param jhkhdm
     * @param jhdm
     * @return
     */
   @PostMapping("selectPurchaseInfoByjhdm")
    @ApiOperation(value = "根据进货客户编码和进货批次号查询进货信息",notes = "根据进货客户编码和进货批次号查询进货信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "jhkhdm",value = "进货客户编码"),
            @ApiImplicitParam(paramType = "query",name = "jhdm",value = "进货批次号"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量")
    })
    public ResponseEntity selectPurchaseInfoByjhdm(String jhkhdm, String jhdm, Pages pages){
        Result result = this.jhMainService.selectPurchaseInfoByjhdm(jhkhdm, jhdm,pages);
        return ResponseEntity.ok(result);
    }
}
