package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import cn.shianxian.supervise.record.service.FunctionaryService;
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

import javax.validation.Valid;

/**
 * app企业负责人控制器
 */
@RestController
@RequestMapping("app/functionary")
@Api(description = "app企业负责人控制器")
@Slf4j
public class AppFunctionaryController {


    @Autowired
    private FunctionaryService functionaryService;


    /**
     * 保存企业负责人
     * @param functionary
     * @return
     */
    @PostMapping("functionary")
    @ApiOperation(value = "保存企业负责人", notes = "保存企业负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "functionaryName", value = "负责人名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryNo", value = "负责人身份证号"),
            @ApiImplicitParam(paramType = "query", name = "functionaryType", value = "负责人类型，1管理，2普通"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "负责人图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "functionaryDisable", value = "负责人是否启用"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "激活KEY"),
            @ApiImplicitParam(paramType = "query", name = "keyUsed", value = "是否已经激活"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "所属企业名称"),
            @ApiImplicitParam(paramType = "query", name = "functionaryPostition", value = "负责人职位，无固定"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> saveFunctionary(@Valid Functionary functionary) {
        log.info("保存企业负责人：{}", functionary);
        return this.functionaryService.saveFunctionary(functionary);
    }


    /**
     * 根据企业标识查询负责人审核表
     * @param nodeTag
     * @return
     */
    @PostMapping("selectFunctionaryForaduitByNodeTag")
    @ApiOperation(value = "根据企业标识查询负责人审核表", notes = "根据企业标识查询负责人审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectFunctionaryForaduitByNodeTag(String nodeTag, Pages pages) {
        return this.functionaryService.selectFunctionaryForaduitByNodeTag(nodeTag, pages);
    }


    /**
     * 根据节点流水号删除负责人申请
     * @param index
     * @return
     */
    @PostMapping("deleteFunctionary")
    @ApiOperation(value = "根据节点流水号删除负责人申请", notes = "根据节点流水号删除负责人申请")
    @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号")
    public ResponseEntity<Result> deleteFunctionary(String index) {
        log.info("根据节点流水号删除负责人申请：{}", index);
        return this.functionaryService.deleteFunctionary(index);
    }


    /**
     * 根据负责人标识、微信id查询负责人
     * @param functionary
     * @return
     */
    @PostMapping("selectFunctionary")
    @ApiOperation(value = "根据负责人标识、微信id查询负责人", notes = "根据负责人标识、微信id查询负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> selectFunctionary(Functionary functionary) {
        return this.functionaryService.selectFunctionary(functionary);
    }

    /**
     * 根据负责人标识、微信id查询负责人备案信息
     * @param functionary
     * @return
     */
    @PostMapping("selectFunctionaryBackUp")
    @ApiOperation(value = "根据负责人标识、微信id查询负责人备案信息", notes = "根据负责人标识、微信id查询负责人备案信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
    })
    public ResponseEntity<Result> selectFunctionaryBackUp(Functionary functionary) {
        return this.functionaryService.selectFunctionaryBackUp(functionary);
    }


    /**
     * 修改企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    @PostMapping("updateFunctionaryForaduit")
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
        log.info("修改企业负责人审核表：{}", functionaryForaduit);
        return this.functionaryService.updateFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 根据企业流水号查询负责人审核表
     * @param index
     * @return
     */
    @PostMapping("selectFunctionaryForaduitByIndex")
    @ApiOperation(value = "根据企业流水号查询负责人审核表", notes = "根据企业流水号查询负责人审核表")
    @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号")
    public ResponseEntity<Result> selectFunctionaryForaduitByIndex(Long index) {
        return this.functionaryService.selectFunctionaryForaduitByIndex(index);
    }


    /**
     * 根据企业标识查询负责人
     * @param nodeTag
     * @return
     */
    @PostMapping("selectFunctionaryByNodeTag")
    @ApiOperation(value = "根据企业标识查询负责人", notes = "根据企业标识查询负责人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectFunctionaryByNodeTag(String nodeTag, Pages pages) {
        return this.functionaryService.selectFunctionaryByNodeTag(nodeTag, pages);
    }


    /**
     * 保存企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    @PostMapping("saveFunctionaryForaduit")
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
        log.info("保存企业负责人审核表：{}", functionaryForaduit);
        return this.functionaryService.saveFunctionaryForaduit(functionaryForaduit);
    }


    /**
     * 根据负责人ID更新负责人信息表
     * @return
     */
    @PostMapping("updateWeChatIdById")
    @ApiOperation(value = "根据负责人ID更新负责人信息表", notes = "根据负责人ID更新负责人信息表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识"),
            @ApiImplicitParam(paramType = "query", name = "weChatId", value = "微信AppID"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "图片"),
    })
    public ResponseEntity<Result> updateWeChatIdById(String functionaryTag, String weChatId, String picTag) {
        return this.functionaryService.updateWeChatIdById(functionaryTag, weChatId, picTag);
    }

}
