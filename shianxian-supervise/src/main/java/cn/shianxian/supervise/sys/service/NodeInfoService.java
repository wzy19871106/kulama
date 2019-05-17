package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import org.springframework.http.ResponseEntity;

public interface NodeInfoService {


    /**
     * 保存、修改节点
     * @param nodeInfo
     * @return
     */
    Result saveOrUpdateNodeInfo(NodeInfo nodeInfo);


    /**
     * 删除节点
     * @param ids
     * @return
     */
    ResponseEntity<Result> deleteNodeInfoById(String ids);


    /**
     * 查询节点
     * @param nodeInfo
     * @return
     */
    Result selectNodeInfo(NodeInfo nodeInfo, Pages pages);


    /**
     * 根据权限查询节点
     * @param authority
     * @return
     */
    Result selectNodeInfoByAuthority(String authority);


    /**
     * 查询节点（树形）
     * @param nodeInfo
     * @param pages
     * @return
     */
    Result selectNodeInfoTreeByLike(NodeInfo nodeInfo, Pages pages);


    /**
     * 修改节点权限
     * @param nodeInfo
     * @return
     */
    Result updateAuthorityById(NodeInfo nodeInfo);

}
