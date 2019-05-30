package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dto.DataAuthorityDTO;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.service.NodeInfoService;
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
 * 节点控制器
 */
@RestController
@Api(description = "节点控制器")
@Slf4j
public class NodeInfoController {


    @Autowired
    private NodeInfoService nodeInfoService;


    /**
     * 保存、修改节点
     * @return
     */
    @PostMapping("saveOrUpdateNodeInfo")
    @ApiOperation(value = "保存、修改节点", notes = "保存、修改节点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "节点名称"),
            @ApiImplicitParam(paramType = "query", name = "nodeNo", value = "节点法人身份证号或统一社会信用代码"),
            @ApiImplicitParam(paramType = "query", name = "nodeTel", value = "节点联系电话"),
            @ApiImplicitParam(paramType = "query", name = "nodeGis", value = "节点GIS经纬度"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "节点图片地址标识"),
            @ApiImplicitParam(paramType = "query", name = "userDataUsedAuthoritySet", value = "用户组的所拥有的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "index", value = "节点流水号"),
            @ApiImplicitParam(paramType = "query", name = "industryTag", value = "节点经济行业标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeProvice", value = "节点所属省"),
            @ApiImplicitParam(paramType = "query", name = "nodeCity", value = "节点所属市"),
            @ApiImplicitParam(paramType = "query", name = "nodeArea", value = "节点所属区"),
            @ApiImplicitParam(paramType = "query", name = "nodeVillage", value = "节点所属乡镇"),
            @ApiImplicitParam(paramType = "query", name = "nodeDisabled", value = "节点是否启用"),
            @ApiImplicitParam(paramType = "query", name = "key", value = "节点激活KEY"),
            @ApiImplicitParam(paramType = "query", name = "keyUsed", value = "keyUsed"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "创建时间"),
    })
    public ResponseEntity<Result> saveOrUpdateNodeInfo(@Valid NodeInfo nodeInfo) {
        log.info("保存、修改节点：{}", nodeInfo);
        Result result = this.nodeInfoService.saveOrUpdateNodeInfo(nodeInfo);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除节点
     * @return
     */
    @DeleteMapping("deleteNodeInfoById")
    @ApiOperation(value = "删除节点", notes = "删除节点")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "ids")
    public ResponseEntity<Result> deleteNodeInfoById(String ids) {
        log.info("删除节点：{}", ids);
        return this.nodeInfoService.deleteNodeInfoById(ids);
    }


    /**
     * 查询节点
     * @return
     */
    @GetMapping("selectNodeInfo")
    @ApiOperation(value = "查询节点", notes = "查询节点")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "节点名称"),
            @ApiImplicitParam(paramType = "query", name = "userDataUsedAuthoritySet", value = "用户组的所拥有的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "industryTag", value = "节点经济行业标识"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectNodeInfo(NodeInfo nodeInfo, Pages pages) {
        Result result = this.nodeInfoService.selectNodeInfo(nodeInfo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据权限查询节点
     * @return
     */
    @GetMapping("selectNodeInfoByAuthority")
    @ApiOperation(value = "根据权限查询节点", notes = "根据权限查询节点")
    @ApiImplicitParam(paramType = "query", name = "authority", value = "用户组的所拥有的数据权限")
    public ResponseEntity<Result> selectNodeInfoByAuthority(String authority) {
        Result result = this.nodeInfoService.selectNodeInfoByAuthority(authority);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询节点（树形）
     * @return
     */
    @GetMapping("selectNodeInfoTreeByLike")
    @ApiOperation(value = "查询节点（树形）", notes = "查询节点（树形）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点标识"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "节点名称"),
            @ApiImplicitParam(paramType = "query", name = "userDataUsedAuthoritySet", value = "用户组的所拥有的数据权限"),
            @ApiImplicitParam(paramType = "query", name = "industryTag", value = "节点经济行业标识"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectNodeInfoTreeByLike(NodeInfo nodeInfo, Pages pages) {
        Result result = this.nodeInfoService.selectNodeInfoTreeByLike(nodeInfo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改节点权限
     * @return
     */
    @PutMapping("updateAuthorityById")
    @ApiOperation(value = "修改节点权限", notes = "修改节点权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "节点标识"),
            @ApiImplicitParam(paramType = "query", name = "userDataUsedAuthoritySet", value = "用户组的所拥有的数据权限"),
    })
    public ResponseEntity<Result> updateAuthorityById(NodeInfo nodeInfo) {
        log.info("修改节点权限：{}", nodeInfo);
        Result result = this.nodeInfoService.updateAuthorityById(nodeInfo);
        return ResponseEntity.ok(result);
    }


    /**
     * 批量赋予节点权限
     * @return
     */
    @PutMapping("batchUpdateNodeInfoAuthority")
    @ApiOperation(value = "批量赋予节点权限", notes = "批量赋予节点权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "ids", value = "id数组"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "所拥有的数据权限"),
    })
    public ResponseEntity<Result> batchUpdateNodeInfoAuthority(@Valid DataAuthorityDTO dataAuthority) {
        log.info("批量赋予节点权限：{}", dataAuthority);
        Result result = this.nodeInfoService.batchUpdateNodeInfoAuthority(dataAuthority);
        return ResponseEntity.ok(result);
    }


    /**
     * 批量清空节点权限
     * @return
     */
    @PutMapping("batchDeleteNodeInfoAuthority")
    @ApiOperation(value = "批量清空节点权限", notes = "批量清空节点权限")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "id数组")
    public ResponseEntity<Result> batchDeleteNodeInfoAuthority(String[] ids) {
        Result result = this.nodeInfoService.batchDeleteNodeInfoAuthority(ids);
        return ResponseEntity.ok(result);
    }


}
