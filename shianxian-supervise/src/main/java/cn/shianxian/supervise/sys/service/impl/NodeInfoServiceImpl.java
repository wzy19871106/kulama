package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.NodeInfoDao;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.service.NodeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class NodeInfoServiceImpl implements NodeInfoService {


    @Autowired
    private NodeInfoDao nodeInfoDao;



    @Transactional
    @Override
    public Result saveOrUpdateNodeInfo(NodeInfo nodeInfo) {
        return null;
    }
}
