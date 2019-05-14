package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.RoleDao;
import cn.shianxian.supervise.sys.dto.AuthorityDTO;
import cn.shianxian.supervise.sys.pojo.Role;
import cn.shianxian.supervise.sys.service.RoleService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;


    @Transactional
    @Override
    public Result saveOrUpdateRole(Role role) {
        // 前端传过来的数据拼json
        Map<String, List<String>> map = new HashMap<>();
        if (StringUtils.isNotBlank(role.getModuleAuthority())) {
            List<AuthorityDTO> authorityList = JSON.parseArray(role.getModuleAuthority(), AuthorityDTO.class);
            for (AuthorityDTO a : authorityList) {
                if (map.containsKey(a.getParent())) {
                    List<String> list = map.get(a.getParent());
                    list.add(a.getValue().substring(0, a.getParent().length()));
                    map.put(a.getParent(), list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(a.getValue().substring(0, a.getParent().length()));
                    map.put(a.getParent(), list);
                }
            }
        }
        System.out.println(JSON.toJSONString(map));
        role.setModuleAuthority(JSON.toJSONString(map));
        if (StringUtils.isBlank(role.getRoleTag())) {
            this.roleDao.insertRole(role);
            log.info("保存角色：{}", role);
        } else {
            this.roleDao.updateRole(role);
            log.info("修改角色：{}", role);
        }
        return Result.successMsg();
    }


    @Override
    public Result selectRoleByPage(QueryPojo queryPojo, Pages pages) {
        List<List<?>> roles = this.roleDao.selectRoleByLike(queryPojo, pages);
        return Result.data(roles);
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteRoleById(String id) {
        String res = this.roleDao.deleteRoleById(id);
        if ("R003".equals(res)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("角色不允许删除！"));
        }
        log.info("删除角色：{}", id);
        return ResponseEntity.ok(Result.successMsg());
    }


}
