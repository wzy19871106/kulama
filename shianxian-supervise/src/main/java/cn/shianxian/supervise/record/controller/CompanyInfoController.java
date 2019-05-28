package cn.shianxian.supervise.record.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import cn.shianxian.supervise.record.service.CompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 企业控制器
 */
@RestController
@RequestMapping("companyInfo")
@Api(description = "企业控制器")
@Slf4j
public class CompanyInfoController {


    @Autowired
    private CompanyInfoService companyInfoService;


    /**
     * 保存企业审核表
     * @param companyInfoForaduit
     * @return
     */
    @PostMapping("companyInfoForaduit")
    @ApiOperation(value = "保存企业审核表", notes = "保存企业审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "nodeNo", value = "企业统一社会信用代码"),
            @ApiImplicitParam(paramType = "query", name = "companyTel", value = "企业联系电话"),
            @ApiImplicitParam(paramType = "query", name = "companyAddress", value = "企业地址"),
            @ApiImplicitParam(paramType = "query", name = "companyProvice", value = "企业所属省"),
            @ApiImplicitParam(paramType = "query", name = "companyCity", value = "企业所属市"),
            @ApiImplicitParam(paramType = "query", name = "companyArea", value = "企业所属区"),
            @ApiImplicitParam(paramType = "query", name = "companyVillage", value = "企业所属乡镇"),
            @ApiImplicitParam(paramType = "query", name = "companyGis", value = "企业GIS经纬度"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "企业图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "aduitType", value = "1新增，2删除，3变更，4审核失败，5注销，0已完成"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回原因"),
    })
    public ResponseEntity<Result> saveCompanyInfoForaduit(@Valid CompanyInfoForaduit companyInfoForaduit) {
        log.info("保存企业审核表：{}", companyInfoForaduit);
        return this.companyInfoService.saveCompanyInfoForaduit(companyInfoForaduit);
    }


    /**
     * 修改企业审核表
     * @param companyInfoForaduit
     * @return
     */
    @PutMapping("companyInfoForaduit")
    @ApiOperation(value = "修改企业审核表", notes = "修改企业审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "nodeNo", value = "企业统一社会信用代码"),
            @ApiImplicitParam(paramType = "query", name = "companyTel", value = "企业联系电话"),
            @ApiImplicitParam(paramType = "query", name = "companyAddress", value = "企业地址"),
            @ApiImplicitParam(paramType = "query", name = "companyProvice", value = "企业所属省"),
            @ApiImplicitParam(paramType = "query", name = "companyCity", value = "企业所属市"),
            @ApiImplicitParam(paramType = "query", name = "companyArea", value = "企业所属区"),
            @ApiImplicitParam(paramType = "query", name = "companyVillage", value = "企业所属乡镇"),
            @ApiImplicitParam(paramType = "query", name = "companyGis", value = "企业GIS经纬度"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "企业图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "aduitType", value = "1新增，2删除，3变更，4审核失败，5注销，0已完成"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回原因"),
    })
    public ResponseEntity<Result> updateCompanyInfoForaduit(@Valid CompanyInfoForaduit companyInfoForaduit) {
        log.info("修改企业审核表：{}", companyInfoForaduit);
        return this.companyInfoService.updateCompanyInfoForaduit(companyInfoForaduit);
    }


    /**
     * 审核企业
     * @param index
     * @return
     */
    @PutMapping("checkCompanyInfoForaduit")
    @ApiOperation(value = "审核企业", notes = "审核企业")
    @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号")
    public ResponseEntity<Result> checkCompanyInfoForaduit(String index) {
        log.info("审核企业：{}", index);
        return this.companyInfoService.checkCompanyInfoForaduit(index);
    }


    /**
     * 退回企业提交审核信息
     * @param companyInfoForaduit
     * @return
     */
    @PutMapping("backCompanyInfoForaduit")
    @ApiOperation(value = "退回企业提交审核信息", notes = "退回企业提交审核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
            @ApiImplicitParam(paramType = "query", name = "failReason", value = "退回原因"),
    })
    public ResponseEntity<Result> backCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        log.info("退回企业提交审核信息：{}", companyInfoForaduit);
        return this.companyInfoService.backCompanyInfoForaduit(companyInfoForaduit);
    }


    /**
     * 对企业审核表进行删除申请
     * @param id
     * @return
     */
    @DeleteMapping("companyInfoForaduit")
    @ApiOperation(value = "对企业表进行删除申请", notes = "对企业表进行删除申请")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> deleteCompanyInfoForaduit(@RequestParam() String id) {
        log.info("对企业审核表进行删除申请：{}", id);
        return this.companyInfoService.deleteCompanyInfoForaduit(id);
    }


    /**
     * 模糊查询企业审核表
     * @param companyInfoForaduit
     * @return
     */
    @GetMapping("selectCompanyInfoForaduitByLike")
    @ApiOperation(value = "模糊查询企业审核表", notes = "模糊查询企业审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "companyProvice", value = "企业所属省"),
            @ApiImplicitParam(paramType = "query", name = "companyCity", value = "企业所属市"),
            @ApiImplicitParam(paramType = "query", name = "companyArea", value = "企业所属区"),
            @ApiImplicitParam(paramType = "query", name = "companyVillage", value = "企业所属乡镇"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectCompanyInfoForaduitByLike(CompanyInfoForaduit companyInfoForaduit, Pages pages) {
        return this.companyInfoService.selectCompanyInfoForaduitByLike(companyInfoForaduit, pages);
    }


    /**
     * 根据id或企业流水号查询企业审核表
     * @param companyInfoForaduit
     * @return
     */
    @GetMapping("selectCompanyInfoForaduit")
    @ApiOperation(value = "根据id或企业流水号查询企业审核表", notes = "根据id或企业流水号查询企业审核表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
    })
    public ResponseEntity<Result> selectCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        return this.companyInfoService.selectCompanyInfoForaduit(companyInfoForaduit);
    }


    /**
     * 模糊查询企业表
     * @param companyInfo
     * @return
     */
    @GetMapping("selectCompanyInfoByLike")
    @ApiOperation(value = "模糊查询企业表", notes = "模糊查询企业表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "companyProvice", value = "企业所属省"),
            @ApiImplicitParam(paramType = "query", name = "companyCity", value = "企业所属市"),
            @ApiImplicitParam(paramType = "query", name = "companyArea", value = "企业所属区"),
            @ApiImplicitParam(paramType = "query", name = "companyVillage", value = "企业所属乡镇"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectCompanyInfoByLike(CompanyInfo companyInfo, Pages pages) {
        return this.companyInfoService.selectCompanyInfoByLike(companyInfo, pages);
    }


    /**
     * 根据id查询企业表
     * @param nodeTag
     * @return
     */
    @GetMapping("selectCompanyInfoById")
    @ApiOperation(value = "根据id查询企业表", notes = "根据id查询企业表")
    @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业标识")
    public ResponseEntity<Result> selectCompanyInfoById(String nodeTag) {
        return this.companyInfoService.selectCompanyInfoById(nodeTag);
    }


    /**
     * 删除企业表
     * @return
     */
    @DeleteMapping("companyInfo")
    @ApiOperation(value = "删除企业表", notes = "删除企业表")
    @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号")
    public ResponseEntity<Result> deleteCompanyInfo(@RequestParam() String index) {
        log.info("删除企业表：{}", index);
        return this.companyInfoService.deleteCompanyInfo(index);
    }

}
