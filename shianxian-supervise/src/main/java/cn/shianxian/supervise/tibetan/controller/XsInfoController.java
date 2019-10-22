package cn.shianxian.supervise.tibetan.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.service.XsInfoService;
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
@RequestMapping("app/XsInsert")
@Api(description = "销售信息控制器")
@Slf4j
public class XsInfoController {

    @Autowired
    private XsInfoService xsInfoService;

    /**
     * 插入销售信息
     * @return
     */
    @PostMapping("saveSalesInfo")
    @ApiOperation(value = "插入销售信息",notes = "插入销售信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "jhdm",value = "进货批次号"),
            @ApiImplicitParam(paramType = "query",name = "xszl",value = "重量"),
            @ApiImplicitParam(paramType = "query",name = "xsspmc",value = "品种"),
            @ApiImplicitParam(paramType = "query",name = "xsdj",value = "单价"),
            @ApiImplicitParam(paramType = "query",name = "xsje",value = "金额"),
            @ApiImplicitParam(paramType = "query",name = "jhindex",value = "排列序号")
    })
    public ResponseEntity saveSalesInfo(@RequestBody List<XsInfoVO> xsInfoVO){
        Result result = this.xsInfoService.saveSalesInfo(xsInfoVO);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询销售信息
     * @param xssjdm
     * @param xsxjdm
     * @param xschecked
     * @return
     */
    @GetMapping("selectXsInfo")
    @ApiOperation(value = "查询销售信息",notes = "查询销售信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "xssjdm",value = "销售上家编码"),
            @ApiImplicitParam(paramType = "query",name = "xsxjdm",value = "销售下家编码"),
            @ApiImplicitParam(paramType = "query",name = "xschecked",value = "巡视状态（1 已巡视 0未巡视）")
    })
    public ResponseEntity selectXsInfo(String xssjdm,String xsxjdm,String xschecked){
        Result result = this.xsInfoService.selectXsInfo(xssjdm, xsxjdm, xschecked);
        return ResponseEntity.ok(result);
    }
}
