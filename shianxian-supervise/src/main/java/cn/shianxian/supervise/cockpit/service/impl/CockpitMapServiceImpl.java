package cn.shianxian.supervise.cockpit.service.impl;

import cn.shianxian.supervise.cockpit.dao.CockpitMapDao;
import cn.shianxian.supervise.cockpit.service.CockpitMapService;
import cn.shianxian.supervise.cockpit.vo.CockpitMapAreaVO;
import cn.shianxian.supervise.cockpit.vo.CockpitMapCityVO;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CockpitMapServiceImpl implements CockpitMapService {

    @Autowired
    private CockpitMapDao cockpitMapDao;

    @Override
    public ResponseEntity<Result> selectCockpitMap(QueryPojo queryPojo) {
        List<List<?>> lists = cockpitMapDao.selectCockpitMap(queryPojo);
        CockpitMapCityVO cockpitMapCityVO = (CockpitMapCityVO)lists.get(0).get(0);
        List<CockpitMapAreaVO> cockpitMapAreaVOList = (List<CockpitMapAreaVO>)lists.get(1);
        cockpitMapCityVO.setCockpitMapAreaVOList(cockpitMapAreaVOList);
        return ResponseEntity.ok(Result.data(cockpitMapCityVO));
    }
}
