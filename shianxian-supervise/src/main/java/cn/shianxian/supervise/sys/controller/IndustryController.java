package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 经济行业
 */
@RestController
@RequestMapping("module")
@Api(description = "经济行业控制器")
public class IndustryController {


    @Autowired
    private IndustryService industryService;


    /**
     * 查询经济行业
     * @return
     */
    @GetMapping("selectIndustry")
    @ApiOperation(value = "查询经济行业接口", notes = "查询经济行业接口")
    public ResponseEntity<Result> selectIndustry() {
        Result result = this.industryService.selectIndustry();
        return ResponseEntity.ok(result);
    }

}
