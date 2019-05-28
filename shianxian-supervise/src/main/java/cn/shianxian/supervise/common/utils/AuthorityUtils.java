package cn.shianxian.supervise.common.utils;

import cn.shianxian.supervise.sys.dto.AuthorityDTO;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorityUtils {


    /**
     * 拼接模块权限数据
     * @param roleAuthority
     * @return
     */
    public static Map<String, List<String>> getModuleAuthority(String roleAuthority) {
        // 前端传过来的数据拼json
        Map<String, List<String>> map = new HashMap<>();
        if (StringUtils.isNotBlank(roleAuthority)) {
            List<AuthorityDTO> authorityList = JSON.parseArray(roleAuthority, AuthorityDTO.class);
            for (AuthorityDTO a : authorityList) {
                if (map.containsKey(a.getParentId())) {
                    List<String> list = map.get(a.getParentId());
                    list.add(a.getId().substring(a.getParentId().length()));
                    map.put(a.getParentId(), list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(a.getId().substring(a.getParentId().length()));
                    map.put(a.getParentId(), list);
                }
            }
        }
        return map;
    }

}
