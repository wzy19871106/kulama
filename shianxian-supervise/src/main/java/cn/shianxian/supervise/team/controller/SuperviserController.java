package cn.shianxian.supervise.team.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.pojo.Superviser;
import cn.shianxian.supervise.team.service.SuperviserService;
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
 * 执法人员控制器
 */
@RestController
@RequestMapping("superviser")
@Api(description = "执法人员控制器")
@Slf4j
public class SuperviserController {


    @Autowired
    private SuperviserService superviserService;


    /**
     * 保存执法人员
     * @return
     */
    @PostMapping("saveSuperviser")
    @ApiOperation(value = "保存执法人员接口", notes = "保存执法人员接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviserTag", value = "执法人员编码"),
            @ApiImplicitParam(paramType = "query", name = "superviserName", value = "执法人员名称"),
            @ApiImplicitParam(paramType = "query", name = "teamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "userNo", value = "身份证号码"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "是否使用", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "图片信息"),
            @ApiImplicitParam(paramType = "query", name = "userTag", value = "绑定账号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> saveSuperviser(@Valid Superviser Superviser) {
        log.info("保存执法人员：{}", Superviser);
        Result result = this.superviserService.saveSuperviser(Superviser);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改执法人员
     * @return
     */
    @PutMapping("updateSuperviser")
    @ApiOperation(value = "修改执法人员接口", notes = "修改执法人员接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviserTag", value = "执法人员编码"),
            @ApiImplicitParam(paramType = "query", name = "superviserName", value = "执法人员名称"),
            @ApiImplicitParam(paramType = "query", name = "teamTag", value = "执法队伍编码"),
            @ApiImplicitParam(paramType = "query", name = "userNo", value = "身份证号码"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "ifUse", value = "是否使用", dataType = "Boolean"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "图片信息"),
            @ApiImplicitParam(paramType = "query", name = "userTag", value = "绑定账号"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建日期"),
            @ApiImplicitParam(paramType = "query", name = "createUserTag", value = "创建人"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateTime", value = "最后更新日期"),
            @ApiImplicitParam(paramType = "query", name = "lastUpdateUser", value = "最后更新人"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除", dataType = "Boolean"),
    })
    public ResponseEntity<Result> updateSuperviser(@Valid Superviser Superviser) {
        log.info("修改执法人员：{}", Superviser);
        Result result = this.superviserService.updateSuperviser(Superviser);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除执法人员
     * @return
     */
    @DeleteMapping("deleteSuperviserById")
    @ApiOperation(value = "删除执法人员接口", notes = "删除执法人员接口")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids，多个id用英文逗号连接")
    public ResponseEntity<Result> deleteSuperviserById(String ids) {
        log.info("删除执法人员：{}", ids);
        return this.superviserService.deleteSuperviserById(ids);
    }


    /**
     * 查询执法人员
     * @return
     */
    @GetMapping("selectSuperviser")
    @ApiOperation(value = "查询执法人员", notes = "查询执法人员")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "parentId", value = "执法队伍id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviser(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviserService.selectSuperviser(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 绑定执法人员
     * @return
     */
    @PutMapping("bindSuperviser")
    @ApiOperation(value = "绑定执法人员", notes = "绑定执法人员")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "superviserTag", value = "执法人员编码"),
            @ApiImplicitParam(paramType = "query", name = "userTag", value = "绑定账号"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "类型1：绑定  2解绑"),
    })
    public ResponseEntity<Result> bindSuperviser(Superviser superviser) {
        Result result = this.superviserService.bindSuperviser(superviser);
        return ResponseEntity.ok(result);
    }
}
