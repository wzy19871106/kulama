package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.vo.XsInfoSaveVO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
            @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "上家编码"),
            @ApiImplicitParam(paramType = "query", name = "xssjmc", value = "上家名称"),
    })
    public ResponseEntity saveSalesInfo(@RequestBody XsInfoSaveVO xsInfoVO) {
        Result result = this.xsInfoService.saveSalesInfo(xsInfoVO);
        log.info("插入销售信息：{}", xsInfoVO);
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
            @ApiImplicitParam(paramType = "query", name = "xspaydm", value = "支付方式编码（1现金 2 银行卡 3 记账）"),
            @ApiImplicitParam(paramType = "query", name = "xsrq", value = "销售日期"),
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
            @ApiImplicitParam(paramType = "query", name = "xsxjdm", value = "销售下家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsxjmc", value = "销售下家名称"),
            @ApiImplicitParam(paramType = "query", name = "xsdm", value = "销售编码"),
            @ApiImplicitParam(paramType = "query", name = "amount", value = "总金额")
    })
    public ResponseEntity saveAmount(@RequestBody XsMainInfoVO xsMainInfoVO) {
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

    /**
     * 根据销售编码，销售日期，销售总金额查询是否有记录
     *
     * @param xsrq
     * @param xszje
     * @param xsdm
     * @return
     */
    @PostMapping("XsSelectIfExist")
    @ApiOperation(value = "根据销售编码查询是否有记录", notes = "根据销售编码查询是否有记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "xsrq", value = "销售日期"),
            @ApiImplicitParam(paramType = "query", name = "xszje", value = "销售总金额"),
            @ApiImplicitParam(paramType = "query", name = "xsdm", value = "销售编码"),
    })
    public ResponseEntity<Result> selectXsMainRecord(String xsrq, String xszje, String xsdm) {
        Result result = this.xsInfoService.selectXsMainIfRecord(xsrq, xszje, xsdm);
        return ResponseEntity.ok(result);
    }


    /**
     * 上家 卖家 巡查
     *
     * @param xssjdm
     * @return
     */
    @PostMapping("XCSelect")
    @ApiOperation(value = "上家 卖家 巡查", notes = "上家 卖家 巡查")
    @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "销售上家编码")
    public ResponseEntity<Result> selectPatrolByXsSjdm(String xssjdm) {
        Result result = this.xsInfoService.selectPatrolByXsSjdm(xssjdm);
        return ResponseEntity.ok(result);
    }


    /**
     * 下家 买家 验单
     *
     * @param xssjdm
     * @return
     */
    @PostMapping("XsGoodsSelect")
    @ApiOperation(value = "下家 买家 验单", notes = "下家 买家 验单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "xssjdm", value = "销售上家编码"),
            @ApiImplicitParam(paramType = "query", name = "xsrq", value = "销售日期"),
    })
    public ResponseEntity<Result> selectVerificationCertificateByXsSjdm(String xssjdm,String xsrq) {
        Result result = this.xsInfoService.selectVerificationCertificateByXsSjdm(xssjdm, xsrq);
        return ResponseEntity.ok(result);
    }
}
