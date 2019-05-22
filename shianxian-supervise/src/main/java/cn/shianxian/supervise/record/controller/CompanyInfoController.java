package cn.shianxian.supervise.record.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import cn.shianxian.supervise.record.service.CompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    public ResponseEntity<Result> updateCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        return ResponseEntity.ok(Result.successMsg());
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("companyInfo")
    @ApiOperation(value = "删除企业", notes = "删除企业")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> delete(@RequestParam() String id) {
        return ResponseEntity.ok(Result.successMsg());
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("companyInfoForaduit")
    @ApiOperation(value = "删除企业", notes = "删除企业")
    @ApiImplicitParam(paramType = "query", name = "id", value = "id")
    public ResponseEntity<Result> deleteCompanyInfoForaduit(@RequestParam() String id) {
        return ResponseEntity.ok(Result.successMsg());
    }

}
