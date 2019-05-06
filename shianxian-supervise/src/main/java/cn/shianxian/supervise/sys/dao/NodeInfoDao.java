package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NodeInfoDao extends Mapper<NodeInfo> {


    /**
     * 新增节点
     * @param nodeInfo
     * @return
     */
    String insertNodeInfo(@Param("nodeInfo") NodeInfo nodeInfo);


    /**
     * 修改节点
     * @param nodeInfo
     * @return
     */
    String updateNodeInfo(@Param("nodeInfo") NodeInfo nodeInfo);


    /**
     * 模糊查询节点
     * @param nodeInfo
     * @return
     */
    List<List<?>> selectNodeInfoByLike(@Param("nodeInfo") NodeInfo nodeInfo, @Param("pages")Pages pages);


    /**
     * 根据id查询节点
     * @param id
     * @return
     */
    List<NodeInfo> selectNodeInfoById(@Param("id") String id);


    /**
     * 根据权限查询节点
     * @param authority
     * @return
     */
    List<NodeInfo> selectNodeInfoByAuthority(@Param("authority") String authority);


    /**
     * 模糊查询节点（树形）
     * @param nodeInfo
     * @return
     */
    List<List<?>> selectNodeInfoTreeByLike(@Param("nodeInfo") NodeInfo nodeInfo, @Param("pages")Pages pages);


    /**
     * 删除节点
     * @param id
     * @return
     */
    String deleteNodeInfoById(@Param("id") String id);


    /**
     * 修改节点权限
     * @param nodeInfo
     * @return
     */
    String updateAuthorityById(@Param("nodeInfo") NodeInfo nodeInfo);


}
