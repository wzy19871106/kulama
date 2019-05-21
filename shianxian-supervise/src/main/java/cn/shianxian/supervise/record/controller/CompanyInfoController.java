package cn.shianxian.supervise.record.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 企业控制器
 */
@RestController
@RequestMapping("companyInfo")
@Api(description = "企业控制器")
public class CompanyInfoController {


    /**
     * 保存
     * @param companyInfo
     * @return
     */
    @PostMapping("companyInfoForaduit")
    @ApiOperation(value = "查询区域", notes = "查询区域")
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
            @ApiImplicitParam(paramType = "query", name = "companyDisabled", value = "企业是否启用"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "企业图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
    })
    public ResponseEntity<Result> save(CompanyInfo companyInfo) {
        return ResponseEntity.ok(Result.successMsg());
    }


    /**
     * 修改
     * @param companyInfo
     * @return
     */
    @PutMapping("companyInfoForaduit")
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
            @ApiImplicitParam(paramType = "query", name = "companyDisabled", value = "企业是否启用"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "企业图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "企业流水号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
    })
    public ResponseEntity<Result> update(CompanyInfo companyInfo) {
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
