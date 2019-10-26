package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/XsInfo")
@Api(description = "销售信息控制器")
@Slf4j
public class XsInfoController {

    @Autowired
    private XsInfoService xsInfoService;

    /**
     * 插入销售信息 4
     *
     * @return
     */
    @PostMapping("XsInsert")
    @ApiOperation(value = "插入销售信息", notes = "插入销售信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "jhdm", value = "进货批次号"),
            @ApiImplicitParam(paramType = "query", name = "xszl", value = "重量"),
            @ApiImplicitParam(paramType = "query", name = "xsspmc", value = "品种"),
            @ApiImplicitParam(paramType = "query", name = "xsdj", value = "单价"),
            @ApiImplicitParam(paramType = "query", name = "xsje", value = "金额"),
            @ApiImplicitParam(paramType = "query", name = "jhindex", value = "排列序号"),
            @ApiImplicitParam(paramType = "query", name = "xspaydm", value = "支付方式编码（1现金 2 银行卡 3 记账）"),
            @ApiImplicitParam(paramType = "query", name = "xspaymc", value = "支付方式名称"),
    })
    public ResponseEntity saveSalesInfo(@RequestBody List<XsInfoVO> xsInfoVO,String xspaydm,String xspaymc) {
        Result result = this.xsInfoService.saveSalesInfo(xsInfoVO,xspaydm,xspaymc);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据各种条件查询销售信息 7
     *
     * @return
     */
    @PostMapping("XsSelect")
    @ApiOperation(value = "根据各种条件查询销售信息", notes = "根据各种条件查询销售信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "销售上家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsxjdm", value = "销售下家编码"),
            @ApiImplicitParam(paramType = "query", name = "xscheckdm", value = "巡查人员编码"),
            @ApiImplicitParam(paramType = "query", name = "xschecksj", value = "上家巡视状态（1 已巡视 0未巡视）"),
            @ApiImplicitParam(paramType = "query", name = "xscheckxj", value = "下家巡视状态（1 已巡视 0未巡视）"),
    })
    public ResponseEntity selectXsInfo(XsMain xsMain) {
        Result result = this.xsInfoService.selectXsInfo(xsMain);
        return ResponseEntity.ok(result);
    }

    /**
     * 插入销售金额  5
     *
     * @param xsMainInfoVO
     * @return
     */

    @PostMapping("XsUpdate")
    @ApiOperation(value = "插入销售金额", notes = "插入销售金额")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "销售上家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsxjdm", value = "销售下家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsxjmc", value = "销售下家名称"),
            @ApiImplicitParam(paramType = "query", name = "xspaydm", value = "支付方式编码"),
            @ApiImplicitParam(paramType = "query", name = "xspaymc", value = "支付方式"),
            @ApiImplicitParam(paramType = "query", name = "xsdm", value = "销售编码"),
            @ApiImplicitParam(paramType = "query", name = "amount", value = "总金额")
    })
    public ResponseEntity saveAmount(@RequestBody List<XsMainInfoVO> xsMainInfoVO) {
        Result result = this.xsInfoService.saveAmount(xsMainInfoVO);
        log.info("插入销售金额:{}", xsMainInfoVO);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据销售上下家编码修改巡视意见 6
     *
     * @param xsMains
     * @return
     */
    @PostMapping("XsCheck")
    @ApiOperation(value = "根据销售上下家编码修改巡视意见", notes = "根据销售上下家编码修改巡视意见")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "xscheckmark", value = "巡视意见"),
            @ApiImplicitParam(paramType = "query", name = "xscheckdm", value = "巡查员编码"),
            @ApiImplicitParam(paramType = "query", name = "xscheckmc", value = "巡查员名称"),
            @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "销售上家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsxjdm", value = "销售下家编码"),
    })
    public ResponseEntity<Result> updateCheckByXsdm(XsMain xsMains) {
        Result result = this.xsInfoService.updateCheckByXsdm(xsMains);
        return ResponseEntity.ok(result);
    }

}
