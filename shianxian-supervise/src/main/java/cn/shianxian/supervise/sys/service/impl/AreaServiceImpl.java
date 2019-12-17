package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.AreaDao;
import cn.shianxian.supervise.sys.pojo.Area;
import cn.shianxian.supervise.sys.service.AreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;


    @Override
    public Result selectArea(QueryPojo queryPojo) {
        List<Area> areaList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryPojo.getId())) {
            areaList = this.areaDao.selectAreaById(queryPojo.getId());
        } else if (StringUtils.isNotBlank(queryPojo.getParentId())) {
            areaList = this.areaDao.selectAreaByParentId(queryPojo.getParentId());
        }
        return Result.data(areaList);
    }

    @Override
    public Result selectCompositionArea(String areaTag) {
        List<Area> citys = areaDao.selectAreaById(areaTag);
        for (Area city : citys) {
            List<Area> regions = areaDao.selectAreaByParentId(city.getAreaTag());
            city.setSubAreas(regions);
            for (Area region : regions) {
                List<Area> countys = areaDao.selectAreaByParentId(region.getAreaTag());
                region.setSubAreas(countys);
            }
        }
        return Result.data(citys);
    }
}
