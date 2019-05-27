package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
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
 * app监管业务控制器
 */
@RestController
@RequestMapping("app/sperviseInfo")
@Api(description = "app监管业务控制器")
public class AppSuperviseInfoController {


    @Autowired
    private SuperviseInfoMainService superviseInfoMainService;


    @Autowired
    private SuperviseInfoSubService superviseInfoSubService;


    /**
     * 根据节点id查询已完成的计划任务的监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByNodePlan")
    @ApiOperation(value = "根据节点id查询监管业务（初始化当前登录企业本年已完成计划任务监管信息，按照日期汇总。）", notes = "根据节点id查询监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByNodePlan(String nodeTag, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByNodePlan(nodeTag, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据id查询已完成的计划任务的监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByIdPlan")
    @ApiOperation(value = "根据id查询已完成的计划任务的监管业务（初始化当前登录企业本，所选计划任务监管信息，按照日期及类型汇总）", notes = "根据id查询已完成的计划任务的监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByIdPlan(String id, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByIdPlan(id, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据节点id查询监管业务
     * @return
     */
    @PostMapping("selectSuperviseInfoByNode")
    @ApiOperation(value = "根据节点id查询监管业务（初始化当前登录企业本年已完成日常抽查监管信息）", notes = "根据节点id查询监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByNode(String nodeTag, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByNode(nodeTag, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据节点id查询所有需整改监管业务
     * @return
     */
    @PostMapping("selectSuperviseRectifyByNode")
    @ApiOperation(value = "根据节点id查询所有需整改监管业务（根据登录用户企业编码初始化绑定该企业所有需整改监管列表）", notes = "根据节点id查询所有需整改监管业务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseRectifyByNode(String nodeTag, Pages pages) {
        Result result = this.superviseInfoSubService.selectSuperviseRectifyByNode(nodeTag, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据业务主类型编码查询该项下所有需整改项详细
     * @return
     */
    @PostMapping("selectSuperviseRectifyById")
    @ApiOperation(value = "根据业务主类型编码查询该项下所有需整改项详细（根据监管编码初始化当前待整改及整改提交的监管项）", notes = "根据业务主类型编码查询该项下所有需整改项详细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管业务id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseRectifyById(String id, Pages pages) {
        Result result = this.superviseInfoSubService.selectSuperviseRectifyById(id, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据id查询监管业务从表
     * @return
     */
    @PostMapping("selectSuperviseInfoSubById")
    @ApiOperation(value = "根据id查询监管业务从表", notes = "根据id查询监管业务从表")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管业务id")
    public ResponseEntity<Result> selectSuperviseInfoSubById(String id) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoSubById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据id修改监管业务从表
     * @return
     */
    @PostMapping("updateSuperviseInfoSubById")
    @ApiOperation(value = "根据id修改监管业务从表", notes = "根据id修改监管业务从表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "subId", value = "自增编码"),
            @ApiImplicitParam(paramType = "query", name = "mainIds", value = "监管业务主类型表外键"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseTag", value = "监管项目编码"),
            @ApiImplicitParam(paramType = "query", name = "superviseName", value = "监管内容详细"),
            @ApiImplicitParam(paramType = "query", name = "resultTag", value = "监管结果编码"),
            @ApiImplicitParam(paramType = "query", name = "resultValue", value = "监管结果值"),
            @ApiImplicitParam(paramType = "query", name = "score", value = "结果分值"),
            @ApiImplicitParam(paramType = "query", name = "advice", value = "整改意见"),
            @ApiImplicitParam(paramType = "query", name = "requst", value = "整改反馈"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "整改反馈附件"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "整改状态  0 无需整改 1，整改完成 2，待整改，3 整改提交，待审核4"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
    })
    public ResponseEntity<Result> updateSuperviseInfoSubById(SuperviseInfoSub superviseInfoSub) {
        Result result = this.superviseInfoSubService.updateSuperviseInfoSubById(superviseInfoSub);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据所选监管业务（主类型）编码查询监管明细
     * @return
     */
    @PostMapping("selectSuperviseInfoDetailById")
    @ApiOperation(value = "根据所选监管业务（主类型）编码查询监管明细", notes = "根据所选监管业务（主类型）编码查询监管明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管业务id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoDetailById(String id, Pages pages) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoDetailById(id, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据监管编码返回待整改的监管内容的整改意见
     * @return
     */
    @PostMapping("selectSuperviseInfoAdviceById")
    @ApiOperation(value = "根据监管编码返回待整改的监管内容的整改意见", notes = "根据监管编码返回待整改的监管内容的整改意见")
    @ApiImplicitParam(paramType = "query", name = "id", value = "监管编码")
    public ResponseEntity<Result> selectSuperviseInfoAdviceById(String id) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoAdviceById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据所选监管业务（主类型）编码查询监管明细（树）
     * @return
     */
    @PostMapping("selectSuperviseInfoDetailTree")
    @ApiOperation(value = "根据所选监管业务（主类型）编码查询监管明细（树）", notes = "根据所选监管业务（主类型）编码查询监管明细（树）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管业务id"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoDetailTree(String id, Pages pages) {
        Result result = this.superviseInfoSubService.selectSuperviseInfoDetailTree(id, pages);
        return ResponseEntity.ok(result);
    }


}
