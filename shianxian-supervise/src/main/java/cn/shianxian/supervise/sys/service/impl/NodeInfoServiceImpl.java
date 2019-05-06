package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.NodeInfoDao;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.service.NodeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class NodeInfoServiceImpl implements NodeInfoService {


    @Autowired
    private NodeInfoDao nodeInfoDao;


    @Transactional
    @Override
    public Result saveOrUpdateNodeInfo(NodeInfo nodeInfo) {
        if (StringUtils.isBlank(nodeInfo.getNodeTag())) {
            this.nodeInfoDao.insertNodeInfo(nodeInfo);
        } else {
            this.nodeInfoDao.updateNodeInfo(nodeInfo);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result deleteNodeInfoById(String id) {
        this.nodeInfoDao.deleteNodeInfoById(id);
        return Result.successMsg();
    }


    @Override
    public Result selectNodeInfo(NodeInfo nodeInfo, Pages pages) {
        Object nodeInfos = null;
        if (StringUtils.isNotBlank(nodeInfo.getNodeTag())) {
            nodeInfos = this.nodeInfoDao.selectNodeInfoById(nodeInfo.getNodeTag());
        } else if (StringUtils.isNoneBlank(nodeInfo.getNodeTag(),
                nodeInfo.getNodeName(),
                nodeInfo.getIndustryTag(),
                nodeInfo.getUserDataUsedAuthoritySet())) {
            nodeInfos = this.nodeInfoDao.selectNodeInfoByLike(nodeInfo, pages);
        }
        return Result.data(nodeInfos);
    }


    @Override
    public Result selectNodeInfoByAuthority(String authority) {
        List<NodeInfo> nodeInfos = this.nodeInfoDao.selectNodeInfoByAuthority(authority);
        return Result.data(nodeInfos);
    }


    @Override
    public Result selectNodeInfoTreeByLike(NodeInfo nodeInfo, Pages pages) {
        List<List<?>> nodeInfos = this.nodeInfoDao.selectNodeInfoTreeByLike(nodeInfo, pages);
        return Result.data(nodeInfos);
    }


    @Transactional
    @Override
    public Result updateAuthorityById(NodeInfo nodeInfo) {
        this.nodeInfoDao.updateAuthorityById(nodeInfo);
        return Result.successMsg();
    }

}
