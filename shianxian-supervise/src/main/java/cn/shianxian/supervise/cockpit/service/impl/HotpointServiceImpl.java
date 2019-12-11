package cn.shianxian.supervise.cockpit.service.impl;

import cn.shianxian.supervise.cockpit.dao.CockpitPlanTaskDao;
import cn.shianxian.supervise.cockpit.dao.HotpointDao;
import cn.shianxian.supervise.cockpit.service.HotpointService;
import cn.shianxian.supervise.cockpit.vo.CockpitAreaHeadVO;
import cn.shianxian.supervise.cockpit.vo.CockpitSuperviseTypeVO;
import cn.shianxian.supervise.cockpit.vo.HotpointAreaVO;
import cn.shianxian.supervise.cockpit.vo.HotpointStreetVO;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotpointServiceImpl implements HotpointService {

    @Autowired
    private HotpointDao hotpointDao;
    @Autowired
    private CockpitPlanTaskDao cockpitPlanTaskDao;

    @Override
    public ResponseEntity<Result> selectHotpoint(String superviseTypeTag) {
        //分解监管类型
        String[] superviseTypeTagArray = superviseTypeTag.split(",");
        List<CockpitAreaHeadVO> CockpitAreaHeadList1 =new ArrayList<>();

        for (String superviseTypeTagstr : superviseTypeTagArray) {
            if(superviseTypeTagstr==null)
            {continue;}
            if(superviseTypeTagstr=="")
            {continue;}
            CockpitAreaHeadVO cockpitAreaHeadVOModel=new CockpitAreaHeadVO();
            cockpitAreaHeadVOModel.setSuperviseTypeTagstr(superviseTypeTagstr);
            //获取所有区域
            List<HotpointAreaVO> hotpointList = hotpointDao.selectAllArea();
            //获取各个区域内的信息
            for (HotpointAreaVO hotpointAreaVO : hotpointList) {
                String areaTag = hotpointAreaVO.getAreaTag();

                List<HotpointStreetVO> hotpointStreetVOList = hotpointDao.selectStreetHotpoint(areaTag, superviseTypeTagstr);
                for (HotpointStreetVO hotpointStreetVO: hotpointStreetVOList) {
                    String streetCoordinate = hotpointStreetVO.getStreetCoordinate();
                    String[] coordinateArray = streetCoordinate.split(",");
                    List<Double> coordinateList = new ArrayList<>();
                    for (String coordinate : coordinateArray) {
                        coordinateList.add(Double.valueOf(coordinate));
                    }
                    hotpointStreetVO.setCoordinate(coordinateList);
                }
                hotpointAreaVO.setHotpointStreetVOList(hotpointStreetVOList);
            }

            cockpitAreaHeadVOModel.setHotpointAreaVOList(hotpointList);
            CockpitAreaHeadList1.add(cockpitAreaHeadVOModel);
        }

        return ResponseEntity.ok(Result.data(CockpitAreaHeadList1));
    }

    @Override
    public ResponseEntity<Result> selectAllSuperviseType() {
        List<CockpitSuperviseTypeVO> cockpitSuperviseTypeVOS = cockpitPlanTaskDao.selectAllSuperviseType();
        return ResponseEntity.ok(Result.data(cockpitSuperviseTypeVOS));
    }

    @Override
    public ResponseEntity<Result> selectAllArea() {
        List<HotpointAreaVO> hotpointAreaVOS = hotpointDao.selectAllArea();
        return ResponseEntity.ok(Result.data(hotpointAreaVOS));
    }
}
