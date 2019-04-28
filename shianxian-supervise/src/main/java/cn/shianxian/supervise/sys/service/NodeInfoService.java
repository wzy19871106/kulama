package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.NodeInfo;

public interface NodeInfoService {


    /**
     * 保存、修改节点
     * @param nodeInfo
     * @return
     */
    Result saveOrUpdateNodeInfo(NodeInfo nodeInfo);
}
