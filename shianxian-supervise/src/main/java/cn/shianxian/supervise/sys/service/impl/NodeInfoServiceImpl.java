package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.sys.dao.NodeInfoDao;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.dto.AuthorityDTO;
import cn.shianxian.supervise.sys.dto.DataAuthorityDTO;
import cn.shianxian.supervise.sys.dto.NodeFunctionaryDTO;
import cn.shianxian.supervise.sys.pojo.NodeInfo;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.NodeInfoService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class NodeInfoServiceImpl implements NodeInfoService {


    @Autowired
    private NodeInfoDao nodeInfoDao;


    @Autowired
    private FunctionaryDao functionaryDao;


    @Autowired
    private UserGroupDao userGroupDao;


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
    public ResponseEntity<Result> deleteNodeInfoById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.nodeInfoDao.deleteNodeInfoById(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectNodeInfo(NodeInfo nodeInfo, Pages pages) {
        List<NodeInfo> nodeInfos = new ArrayList<>();
        if (StringUtils.isNotBlank(nodeInfo.getNodeTag())) {
            nodeInfos = this.nodeInfoDao.selectNodeInfoById(nodeInfo.getNodeTag());
        } else if (null != nodeInfo.getNodeTag() &&
                null != nodeInfo.getNodeName() &&
                null != nodeInfo.getIndustryTag() &&
                null != nodeInfo.getUserDataUsedAuthoritySet()) {
            List<List<?>> list = this.nodeInfoDao.selectNodeInfoByLike(nodeInfo, pages);
            return Result.data((Long) list.get(2).get(0), list.get(0));
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
        List<List<?>> list = this.nodeInfoDao.selectNodeInfoTreeByLike(nodeInfo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Transactional
    @Override
    public Result updateAuthorityById(NodeInfo nodeInfo) {
        // 根据前端传来的权限id，查出权限数据拼接
        String authority = nodeInfo.getUserDataUsedAuthoritySet();
        if (StringUtils.isNotBlank(authority)) {
            List<AuthorityDTO> authorityDTOS = JSON.parseArray(authority, AuthorityDTO.class);
            UserGroup userGroup = new UserGroup();
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for (AuthorityDTO authorityDTO : authorityDTOS) {
                userGroup.setUserGroupTag(authorityDTO.getId());
                List<UserGroup> groups = this.userGroupDao.select(userGroup);
                if (!groups.isEmpty()) {
                    set.add(groups.get(0).getUserDataAuthority());
                }
            }
            for (String s : set) {
                sb.append(s).append(",");
            }
            if (sb.length() > 0) {
                String authoritys = sb.substring(0, sb.length() - 1);
                nodeInfo.setUserDataUsedAuthoritySet(authoritys);
                this.nodeInfoDao.updateAuthorityById(nodeInfo);
            }
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> checkKey(String key, String weChatId) {
        NodeFunctionaryDTO nodeInfo = new NodeFunctionaryDTO();
        Functionary f = new Functionary();
        nodeInfo.setFunctionary(f);
        nodeInfo.setFlag("3");
        if (StringUtils.isNotBlank(key)) {
            nodeInfo = this.nodeInfoDao.checkKey(key, weChatId);
            Functionary functionary = this.functionaryDao.selectFunctionaryByWeChatId(weChatId);
            if (null != functionary) {
                nodeInfo.setFunctionary(functionary);
            }
        }
        return ResponseEntity.ok(Result.data(nodeInfo));
    }


    @Transactional
    @Override
    public Result batchUpdateNodeInfoAuthority(DataAuthorityDTO dataAuthority) {
        // 根据前端传来的权限id，查出权限数据拼接
        String authority = dataAuthority.getAuthority();
        List<AuthorityDTO> authorityDTOS = JSON.parseArray(authority, AuthorityDTO.class);
        UserGroup userGroup = new UserGroup();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (AuthorityDTO authorityDTO : authorityDTOS) {
            userGroup.setUserGroupTag(authorityDTO.getId());
            List<UserGroup> groups = this.userGroupDao.select(userGroup);
            if (!groups.isEmpty()) {
                set.add(groups.get(0).getUserDataAuthority());
            }
        }
        for (String s : set) {
            sb.append(s).append(",");
        }
        if (sb.length() > 0) {
            String authoritys = sb.substring(0, sb.length() - 1);
            // 批量赋予节点权限
            String[] ids = dataAuthority.getIds();
            for (String id : ids) {
                this.nodeInfoDao.updateNodeInfoAuthority(id, authoritys);
            }
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result batchDeleteNodeInfoAuthority(String[] ids) {
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setUserDataUsedAuthoritySet("");
        for (String id : ids) {
            nodeInfo.setNodeTag(id);
            this.nodeInfoDao.updateAuthorityById(nodeInfo);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectNodeInfoAuthorityById(String id) {
        // 根据节点id查询节点权限
        NodeInfo nodeInfo = this.nodeInfoDao.selectByPrimaryKey(id);
        List<String> list = new ArrayList<>();
        if (null != nodeInfo && StringUtils.isNotBlank(nodeInfo.getUserDataUsedAuthoritySet())) {
            String[] authority = nodeInfo.getUserDataUsedAuthoritySet().split(",");
            UserGroup userGroup = new UserGroup();
            for (String a : authority) {
                if (!"0".equals(a)) {
                    userGroup.setUserDataAuthority(a);
                    List<UserGroup> userGroupList = this.userGroupDao.select(userGroup);
                    if (!userGroupList.isEmpty()) {
                        list.add(userGroupList.get(0).getUserGroupTag());
                    }
                }
            }
        }
        return Result.data(list);
    }


    @Override
    public Result selectNodeInfoByPlanTag(String planTag, String authority) {
        List<NodeInfo> nodeInfos = this.nodeInfoDao.selectNodeInfoByPlanTag(planTag, authority);
        return Result.data(nodeInfos);
    }

}
