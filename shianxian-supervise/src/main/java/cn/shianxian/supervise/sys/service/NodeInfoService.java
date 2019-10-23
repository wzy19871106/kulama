package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dto.DataAuthorityDTO;
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
     * 查询办事处
     * @return
     */
    Result selectNodeInfoOffice();

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


    /**
     * 校验key
     * @param key
     * @return
     */
    ResponseEntity<Result> checkKey(String key, String weChatId);


    /**
     * 批量赋予节点权限
     * @param dataAuthority
     * @return
     */
    Result batchUpdateNodeInfoAuthority(DataAuthorityDTO dataAuthority);


    /**
     * batchDeleteNodeInfoAuthority
     * @param ids
     * @return
     */
    Result batchDeleteNodeInfoAuthority(String[] ids);


    /**
     * 根据节点id查询节点权限
     * @param id
     * @return
     */
    Result selectNodeInfoAuthorityById(String id);


    /**
     * 根据计划任务标识，数据权限模板标识查询节点表
     * @param planTag
     * @return
     */
    Result selectNodeInfoByPlanTag(String planTag, String authority);
}
