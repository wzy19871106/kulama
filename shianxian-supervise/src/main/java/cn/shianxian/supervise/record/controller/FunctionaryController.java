package cn.shianxian.supervise.record.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import cn.shianxian.supervise.record.service.FunctionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 企业负责人控制器
 */
@RestController
@RequestMapping("functionary")
@Api(description = "企业负责人控制器")
public class FunctionaryController {


    @Autowired
    private FunctionaryService functionaryService;


    /**
     * 保存企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    @PostMapping("functionaryForaduit")
    @ApiOperation(value = "保存企业负责人审核表", notes = "保存企业负责人审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryNo", value = "负责人身份证号"),
            @ApiImplicitParam(paramType = "query", name = "functionaryType", value = "负责人类型，1管理，2普通"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "负责人图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "aduitType", value = "审核状态:1新增，2删除，3变更，4审核失败，5注销，6注销通过，0已完成"),
            @ApiImplicitParam(paramType = "query", name = "updateTime", value = "注销时间"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回说明"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "激活KEY"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "所属企业名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryPostition", value = "负责人职位，无固定"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> saveFunctionaryForaduit(@Valid FunctionaryForaduit functionaryForaduit) {
        return this.functionaryService.saveFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 修改企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    @PutMapping("functionaryForaduit")
    @ApiOperation(value = "修改企业负责人审核表", notes = "修改企业负责人审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryNo", value = "负责人身份证号"),
            @ApiImplicitParam(paramType = "query", name = "functionaryType", value = "负责人类型，1管理，2普通"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "负责人图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "aduitType", value = "审核状态:1新增，2删除，3变更，4审核失败，5注销，6注销通过，0已完成"),
            @ApiImplicitParam(paramType = "query", name = "updateTime", value = "注销时间"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回说明"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "激活KEY"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "所属企业名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryPostition", value = "负责人职位，无固定"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> updateFunctionaryForaduit(@Valid FunctionaryForaduit functionaryForaduit) {
        return this.functionaryService.updateFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 审核通过负责人审核信息
     * @param index
     * @return
     */
    @PutMapping("checkFunctionaryForaduit")
    @ApiOperation(value = "审核通过负责人审核信息", notes = "审核通过负责人审核信息")
    @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号")
    public ResponseEntity<Result> checkFunctionaryForaduit(String index) {
        return this.functionaryService.checkFunctionaryForaduit(index);
    }


    /**
     * 退回负责人提交审核信息
     * @param functionaryForaduit
     * @return
     */
    @PutMapping("backFunctionaryForaduit")
    @ApiOperation(value = "退回负责人提交审核信息", notes = "退回负责人提交审核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回说明"),
    })
    public ResponseEntity<Result> backFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        return this.functionaryService.backFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 根据各种查询条件查询负责人审核表
     * @param queryPojo
     * @return
     */
    @GetMapping("selectFunctionaryForaduitByLike")
    @ApiOperation(value = "根据各种查询条件查询负责人审核表", notes = "根据各种查询条件查询负责人审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectFunctionaryForaduitByLike(QueryPojo queryPojo, Pages pages) {
        return this.functionaryService.selectFunctionaryForaduitByLike(queryPojo, pages);
    }


    /**
     * 根据id或企业流水号查询负责人审核表
     * @param functionaryForaduit
     * @return
     */
    @GetMapping("selectFunctionaryForaduit")
    @ApiOperation(value = "根据id或企业流水号查询负责人审核表", notes = "根据id或企业流水号查询负责人审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
    })
    public ResponseEntity<Result> selectFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        return this.functionaryService.selectFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 根据参数对负责人审核表进行删除申请
     * @param id
     * @return
     */
    @DeleteMapping("functionaryForaduit")
    @ApiOperation(value = "根据参数对负责人审核表进行删除申请", notes = "根据参数对负责人审核表进行删除申请")
    @ApiImplicitParam(paramType = "query", name = "id", value = "负责人标识")
    public ResponseEntity<Result> deleteFunctionaryForaduit(String id) {
        return this.functionaryService.deleteFunctionaryForaduit(id);
    }


    /**
     * 根据各种查询条件查询负责人
     * @param queryPojo
     * @return
     */
    @GetMapping("selectFunctionaryByLike")
    @ApiOperation(value = "根据各种查询条件查询负责人", notes = "根据各种查询条件查询负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectFunctionaryByLike(QueryPojo queryPojo, Pages pages) {
        return this.functionaryService.selectFunctionaryByLike(queryPojo, pages);
    }


    /**
     * 根据id、负责人标识、微信id查询负责人
     * @param functionary
     * @return
     */
    @GetMapping("selectFunctionary")
    @ApiOperation(value = "根据id、负责人标识、微信id查询负责人", notes = "根据id、负责人标识、微信id查询负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> selectFunctionary(Functionary functionary) {
        return this.functionaryService.selectFunctionary(functionary);
    }


    /**
     * 根据节点流水号删除负责人申请
     * @param index
     * @return
     */
    @DeleteMapping("functionary")
    @ApiOperation(value = "根据节点流水号删除负责人申请", notes = "根据节点流水号删除负责人申请")
    @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号")
    public ResponseEntity<Result> deleteFunctionary(String index) {
        return this.functionaryService.deleteFunctionary(index);
    }
}
