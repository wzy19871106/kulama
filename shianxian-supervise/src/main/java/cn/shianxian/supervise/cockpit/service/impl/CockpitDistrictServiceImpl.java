package cn.shianxian.supervise.cockpit.service.impl;

import cn.shianxian.supervise.cockpit.dao.CockpitDistrictDao;
import cn.shianxian.supervise.cockpit.service.CockpitDistrictService;
import cn.shianxian.supervise.cockpit.vo.CockpitDistrictVO;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CockpitDistrictServiceImpl implements CockpitDistrictService {

    @Autowired
    CockpitDistrictDao cockpitDistrictDao;

    @Override
    public ResponseEntity<Result> selectDistrictInfo() {
        List<CockpitDistrictVO> cockpitDistrictVOS = cockpitDistrictDao.selectAll();
        return ResponseEntity.ok(Result.data(cockpitDistrictVOS));
    }

}
