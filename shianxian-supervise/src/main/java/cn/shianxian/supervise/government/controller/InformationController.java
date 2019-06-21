package cn.shianxian.supervise.government.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.pojo.Information;
import cn.shianxian.supervise.government.service.InformationService;
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
 * 政企互动控制器
 */
@RestController
@RequestMapping("information")
@Api(description = "政企互动控制器")
@Slf4j
public class InformationController {


    @Autowired
    private InformationService informationService;


    /**
     * 保存、修改政企互动信息
     * @return
     */
    @PostMapping("information")
    @ApiOperation(value = "保存、修改政企互动信息", notes = "保存、修改政企互动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "index", value = "政企互动标识"),
            @ApiImplicitParam(paramType = "query", name = "title", value = "政企互动标题"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "政企互动图片"),
            @ApiImplicitParam(paramType = "query", name = "content", value = "政企互动内容"),
            @ApiImplicitParam(paramType = "query", name = "ifTop", value = "是否置顶"),
            @ApiImplicitParam(paramType = "query", name = "ifDisable", value = "是否启用"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
            @ApiImplicitParam(paramType = "query", name = "updateTime", value = "最后修改时间"),
            @ApiImplicitParam(paramType = "query", name = "columnTag", value = "栏目标识"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "对象用户标识(暂不用)"),
            @ApiImplicitParam(paramType = "query", name = "userGroupId", value = "对象用户组标识(暂不用)"),
    })
    public ResponseEntity<Result> saveOrUpdateInformation(@Valid Information information) {
        log.info("保存、修改政企互动信息：{}", information);
        return this.informationService.saveOrUpdateInformation(information);
    }


    /**
     * 删除政企互动信息
     * @return
     */
    @DeleteMapping("information")
    @ApiOperation(value = "删除政企互动信息", notes = "删除政企互动信息")
    @ApiImplicitParam(paramType = "query", name = "index", value = "政企互动标识")
    public ResponseEntity<Result> deleteInformation(@RequestParam Long index) {
        log.info("删除政企互动信息：{}", index);
        return this.informationService.deleteInformation(index);
    }


    /**
     * 查询政企互动信息
     * @return
     */
    @GetMapping("information")
    @ApiOperation(value = "查询政企互动信息", notes = "查询政企互动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "栏目id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectInformation(QueryPojo queryPojo, Pages pages) {
        return this.informationService.selectInformation(queryPojo, pages);
    }


    /**
     * 根据id查询政企互动信息
     * @return
     */
    @GetMapping("selectInformationById")
    @ApiOperation(value = "根据id查询政企互动信息", notes = "根据id查询政企互动信息")
    @ApiImplicitParam(paramType = "query", name = "index", value = "政企互动标识")
    public ResponseEntity<Result> selectInformationById(String index) {
        return this.informationService.selectInformationById(index);
    }


    /**
     * 修改政企互动信息置顶
     * @return
     */
    @PutMapping("updateInformationTop")
    @ApiOperation(value = "修改政企互动信息置顶", notes = "修改政企互动信息置顶")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "index", value = "政企互动标识"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "类型[1：置顶，2：取消置顶]"),
    })    public ResponseEntity<Result> updateInformationTop(String index, int type) {
        return this.informationService.updateInformationTop(index, type);
    }

}
