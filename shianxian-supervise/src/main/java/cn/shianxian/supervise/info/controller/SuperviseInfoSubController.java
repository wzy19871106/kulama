package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 监管业务（从表）控制器
 */
@RestController
@RequestMapping("sperviseInfoSub")
@Api(description = "监管业务（从表）控制器")
public class SuperviseInfoSubController {


    @Autowired
    private SuperviseInfoSubService superviseInfoSubService;


    /**
     * 根据监管编码返回待整改的监管内容的整改意见
     * @return
     */
    @GetMapping("selectSuperviseInfoAdviceById")
    @ApiOperation(value = "根据监管编码返回待整改的监管内容的整改意见", notes = "根据监管编码返回待整改的监管内容的整改意见")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管编码")
    public ResponseEntity<Result> selectSuperviseInfoAdviceById(String id) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoAdviceById(id);
        return ResponseEntity.ok(result);
    }

}
