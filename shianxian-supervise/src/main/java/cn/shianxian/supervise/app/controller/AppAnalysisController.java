package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.service.AnalysisService;
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
 * app数据分析控制器
 */
@RestController
@RequestMapping("app/analysis")
@Api(description = "app数据分析控制器")
@Slf4j
public class AppAnalysisController {


    @Autowired
    private AnalysisService analysisService;


    /**
     * 以月度为单位，展示本企业综合评分趋势
     * @return
     */
    @PostMapping("selectCompanyLine")
    @ApiOperation(value = "以月度为单位，展示本企业综合评分趋势", notes = "以月度为单位，展示本企业综合评分趋势")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectCompanyLine(QueryPojo queryPojo) {
        return this.analysisService.selectCompanyLine(queryPojo);
    }


    /**
     * 根据时间段，企业编码，返回所需汇总数据(企业雷达图)
     * @return
     */
    @PostMapping("selectCompanyRadar")
    @ApiOperation(value = "根据时间段，企业编码，返回所需汇总数据(企业雷达图)", notes = "根据时间段，企业编码，返回所需汇总数据(企业雷达图)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectCompanyRadar(QueryPojo queryPojo) {
        return this.analysisService.selectCompanyRadar(queryPojo);
    }


    /**
     * 以月度为单位，展示本行业综合评分趋势
     * @return
     */
    @PostMapping("selectIndustryLine")
    @ApiOperation(value = "以月度为单位，展示本行业综合评分趋势", notes = "以月度为单位，展示本行业综合评分趋势")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectIndustryLine(QueryPojo queryPojo) {
        return this.analysisService.selectIndustryLine(queryPojo);
    }


    /**
     * 根据时间段，企业编码，返回所需汇总数据(行业雷达图)
     * @return
     */
    @PostMapping("selectIndustryRadar")
    @ApiOperation(value = "根据时间段，企业编码，返回所需汇总数据(行业雷达图)", notes = "根据时间段，企业编码，返回所需汇总数据(行业雷达图)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectIndustryRadar(QueryPojo queryPojo) {
        return this.analysisService.selectIndustryRadar(queryPojo);
    }


    /**
     * 根据时间段，企业编码，返回所需汇总数据
     * @return
     */
    @PostMapping("selectAnalysisNodeInfo")
    @ApiOperation(value = "根据时间段，企业编码，返回所需汇总数据", notes = "根据时间段，企业编码，返回所需汇总数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectAnalysisNodeInfo(QueryPojo queryPojo) {
        return this.analysisService.selectAnalysisNodeInfo(queryPojo);
    }


    /**
     * 时间段内企业综合评分排行情况。如企业非前5排行：显示前5企业+本企业开始的5家排行;如企业是前5排行：直接显示TOP10排行
     * @return
     */
    @PostMapping("selectAnalysisScore")
    @ApiOperation(value = "时间段内企业综合评分排行情况。如企业非前5排行：显示前5企业+本企业开始的5家排行;如企业是前5排行：直接显示TOP10排行", notes = "时间段内企业综合评分排行情况。如企业非前5排行：显示前5企业+本企业开始的5家排行;如企业是前5排行：直接显示TOP10排行")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
    })
    public ResponseEntity<Result> selectAnalysisScore(QueryPojo queryPojo) {
        return this.analysisService.selectAnalysisScore(queryPojo);
    }
}
