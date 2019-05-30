package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.SuperviseTypeDao;
import cn.shianxian.supervise.sys.dao.UserGroupDao;
import cn.shianxian.supervise.sys.dto.AuthorityDTO;
import cn.shianxian.supervise.sys.dto.DataAuthorityDTO;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import cn.shianxian.supervise.sys.pojo.UserGroup;
import cn.shianxian.supervise.sys.service.SuperviseTypeService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperviseTypeServiceImpl implements SuperviseTypeService {


    @Autowired
    private SuperviseTypeDao superviseTypeDao;


    @Autowired
    private UserGroupDao userGroupDao;


    @Transactional
    @Override
    public Result saveOrUpdateSuperviseType(SuperviseType SuperviseType) {
        if (StringUtils.isBlank(SuperviseType.getSuperviseTypeTag())) {
            this.superviseTypeDao.insertSuperviseType(SuperviseType);
        } else {
            this.superviseTypeDao.updateSuperviseType(SuperviseType);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteSuperviseTypeById(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            String flag = this.superviseTypeDao.deleteSuperviseType(id);
            if (!"R001".equals(flag)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public Result selectSuperviseType(SuperviseType superviseType) {
        List<SuperviseType> superviseTypes = this.superviseTypeDao.selectSuperviseType(superviseType.getSuperviseTypeTag(), superviseType.getUserGroupDataAuthority());
        return Result.data(superviseTypes);
    }


    @Transactional
    @Override
    public Result updateSuperviseTypeBySort(String id, int type) {
        if (1 == type) {
            this.superviseTypeDao.updateSuperviseTypeByUpSort(id);
        }
        if (2 == type) {
            this.superviseTypeDao.updateSuperviseTypeByDownSort(id);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseTypeTree(SuperviseType superviseType) {
        String tree = this.superviseTypeDao.selectSuperviseTypeTree(superviseType);
        return Result.data(tree);
    }


    @Override
    public Result selectSuperviseTypeById(String id) {
        SuperviseType superviseType = this.superviseTypeDao.selectByPrimaryKey(id);
        return Result.data(superviseType);
    }


    @Transactional
    @Override
    public Result batchUpdateSuperviseTypeAuthority(DataAuthorityDTO dataAuthorityDTO) {
        // 根据前端传来的权限id，查出权限数据拼接
        String authority = dataAuthorityDTO.getAuthority();
        List<AuthorityDTO> authorityDTOS = JSON.parseArray(authority, AuthorityDTO.class);
        UserGroup userGroup = new UserGroup();
        StringBuilder sb = new StringBuilder();
        for (AuthorityDTO authorityDTO : authorityDTOS) {
            if (authorityDTO.getChildren().isEmpty()) {
                userGroup.setUserGroupTag(authorityDTO.getId());
                List<UserGroup> groups = this.userGroupDao.select(userGroup);
                if (!groups.isEmpty()) {
                    sb.append(groups.get(0).getUserDataAuthority()).append(",");
                }
            }
        }
        String authoritys = sb.substring(0, sb.length() - 1);
        // 批量赋予节点权限
        String[] ids = dataAuthorityDTO.getIds();
        SuperviseType superviseType = new SuperviseType();
        superviseType.setUserGroupDataAuthority(authoritys);
        for (String id : ids) {
            superviseType.setSuperviseTypeTag(id);
            this.superviseTypeDao.saveSuperviseTypeAuthority(superviseType);
        }
        return Result.successMsg();
    }


    @Transactional
    @Override
    public Result batchDeleteSuperviseTypeAuthority(String[] ids) {
        SuperviseType superviseType = new SuperviseType();
        superviseType.setUserGroupDataAuthority("");
        for (String id : ids) {
            superviseType.setSuperviseTypeTag(id);
            this.superviseTypeDao.updateSuperviseTypeAuthority(superviseType);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseTypeAuthorityById(String id) {
        // 根据节点id查询节点权限
        SuperviseType superviseType = this.superviseTypeDao.selectByPrimaryKey(id);
        List<String> list = new ArrayList<>();
        if (null != superviseType && StringUtils.isNotBlank(superviseType.getUserGroupDataAuthority())) {
            String[] authority = superviseType.getUserGroupDataAuthority().split(",");
            UserGroup userGroup = new UserGroup();
            for (String a : authority) {
                userGroup.setUserDataAuthority(a);
                List<UserGroup> userGroupList = this.userGroupDao.select(userGroup);
                if (!userGroupList.isEmpty()) {
                    list.add(userGroupList.get(0).getUserGroupTag());
                }
            }
        }
        return Result.data(list);
    }


    @Transactional
    @Override
    public Result updateSuperviseTypeAuthority(SuperviseType superviseType) {
        // 根据前端传来的权限id，查出权限数据拼接
        String authority = superviseType.getUserGroupDataAuthority();
        if (StringUtils.isNotBlank(authority)) {
            List<AuthorityDTO> authorityDTOS = JSON.parseArray(authority, AuthorityDTO.class);
            UserGroup userGroup = new UserGroup();
            StringBuilder sb = new StringBuilder();
            for (AuthorityDTO authorityDTO : authorityDTOS) {
                if (authorityDTO.getChildren().isEmpty()) {
                    userGroup.setUserGroupTag(authorityDTO.getId());
                    List<UserGroup> groups = this.userGroupDao.select(userGroup);
                    if (!groups.isEmpty()) {
                        sb.append(groups.get(0).getUserDataAuthority()).append(",");
                    }
                }
            }
            String authoritys = sb.substring(0, sb.length() - 1);
            superviseType.setUserGroupDataAuthority(authoritys);
            this.superviseTypeDao.updateSuperviseTypeAuthority(superviseType);
        }
        return Result.successMsg();
    }

}
