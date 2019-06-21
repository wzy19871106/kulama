package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.service.RedisService;
import cn.shianxian.supervise.record.dao.CompanyInfoDao;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import cn.shianxian.supervise.sys.service.MapService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapServiceImpl implements MapService {


    @Autowired
    private RedisService redisService;


    @Autowired
    private CompanyInfoDao companyInfoDao;


    @Transactional
    @Override
    public Result saveSite(String nodeTag, String site) {
        this.redisService.set(nodeTag, site, 3600);
        return Result.successMsg();
    }


    @Override
    public Result selectSite(String nodeTag) {
        String nodeGis = "0";
        String superviserGis = "0";
        String site = this.redisService.get(nodeTag);
        CompanyInfo companyInfo = companyInfoDao.selectByPrimaryKey(nodeTag);
        if (companyInfo != null && StringUtils.isNotBlank(companyInfo.getCompanyGis())) {
            nodeGis = companyInfo.getCompanyGis();
        }
        if (StringUtils.isNotBlank(site)) {
            superviserGis = site;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("node", nodeGis);
        map.put("superviser", superviserGis);
        return Result.data(map);
    }

}
