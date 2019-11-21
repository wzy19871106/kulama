package cn.shianxian.supervise.cockpit.service.impl;

import cn.shianxian.supervise.cockpit.dao.CockpitPlanTaskDao;
import cn.shianxian.supervise.cockpit.service.CockpitPlanTaskService;
import cn.shianxian.supervise.cockpit.vo.*;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CockpitPlanTaskServiceImpl implements CockpitPlanTaskService {

    @Autowired
    private CockpitPlanTaskDao cockpitPlanTaskDao;

    @Override
    public ResponseEntity<Result> selectCockpitPlan() {
        CockpitPlanTaskVO cockpitPlanTaskVO = new CockpitPlanTaskVO();
        List<List<Object>> cockpitPlanAreaBarList = new ArrayList<>();
        List<List<Object>> cockpitPlanDistrictBarList = new ArrayList<>();
        List<CockpitPlanAreaCompositeVO> cockpitPlanAreaCompositeVOList = new ArrayList<>();

        //全市计划任务总体完成情况监管类型百分比图
        List<List<?>> lists = cockpitPlanTaskDao.selectCockpitPlan();
        List<CockpitPlanSuperviseTypeCircleVO> CockpitPlanSuperviseTypeCircleList = (List<CockpitPlanSuperviseTypeCircleVO>) lists.get(0);
        cockpitPlanTaskVO.setCockpitPlanSuperviseTypeCircleVOList(CockpitPlanSuperviseTypeCircleList);

        //全市计划任务总体完成情况区县柱状图
        List<CockpitPlanAreaBarVO> cockpitPlanAreaBars = (List<CockpitPlanAreaBarVO>) lists.get(1);
        for (CockpitPlanAreaBarVO cockpitPlanAreaBarVO : cockpitPlanAreaBars) {
            List<Object> barList = new ArrayList<>();
            barList.add(cockpitPlanAreaBarVO.getAreaName());
            barList.add(cockpitPlanAreaBarVO.getFinishTaskNum());
            barList.add(cockpitPlanAreaBarVO.getPlanTaskNum());
            cockpitPlanAreaBarList.add(barList);
        }
        cockpitPlanTaskVO.setCockpitPlanAreaBarList(cockpitPlanAreaBarList);

        //完成情况-监管所排名
        List<CockpitPlanDistrictBarVO> cockpitPlanDistrictBars = (List<CockpitPlanDistrictBarVO>) lists.get(2);
        for(CockpitPlanDistrictBarVO cockpitPlanDistrictBarVO : cockpitPlanDistrictBars){
            List<Object> barList = new ArrayList<>();
            barList.add(cockpitPlanDistrictBarVO.getDistrictName());
            barList.add(cockpitPlanDistrictBarVO.getPercent());
            cockpitPlanDistrictBarList.add(barList);
        }
        cockpitPlanTaskVO.setCockpitPlanDistrictBarList(cockpitPlanDistrictBarList);

        //各区县计划任务完成情况
        List<CockpitAreaVO> cockpitAreaVOs = cockpitPlanTaskDao.selectAllArea();
        for(CockpitAreaVO cockpitAreaVO : cockpitAreaVOs){
            String areaTag = cockpitAreaVO.getAreaTag();
            String areaName = cockpitAreaVO.getAreaName();
            List<CockpitPlanAreaSuperviseTypeCompositeVO> cockpitPlanAreaSuperviseTypeCompositeVOS = cockpitPlanTaskDao.selectCockpitPlanComposite(areaTag);
            CockpitPlanAreaCompositeVO cockpitPlanAreaCompositeVO = new CockpitPlanAreaCompositeVO();
            cockpitPlanAreaCompositeVO.setAreaName(areaName);
            cockpitPlanAreaCompositeVO.setCockpitPlanAreaSuperviseTypeCompositeVOList(cockpitPlanAreaSuperviseTypeCompositeVOS);
            List<List<Object>> SuperviseTypeBarList = new ArrayList<>();
            for(CockpitPlanAreaSuperviseTypeCompositeVO cockpitPlanAreaSuperviseTypeCompositeVO : cockpitPlanAreaSuperviseTypeCompositeVOS){
                List<Object> barList = new ArrayList<>();
                barList.add(cockpitPlanAreaSuperviseTypeCompositeVO.getSuperviseTypeName());
                barList.add(cockpitPlanAreaSuperviseTypeCompositeVO.getPlanTaskNum());
                barList.add(cockpitPlanAreaSuperviseTypeCompositeVO.getFinishTaskNum());
                barList.add(cockpitPlanAreaSuperviseTypeCompositeVO.getDailycheckNum());
                SuperviseTypeBarList.add(barList);
            }
            cockpitPlanAreaCompositeVO.setSuperviseTypeBarList(SuperviseTypeBarList);
            cockpitPlanAreaCompositeVOList.add(cockpitPlanAreaCompositeVO);
        }
        cockpitPlanTaskVO.setCockpitPlanAreaCompositeList(cockpitPlanAreaCompositeVOList);

        //巡查任务完成情况
        List<CockpitSuperviseTypeVO> cockpitSuperviseTypeVOS = cockpitPlanTaskDao.selectAllSuperviseType();
        CockpitPlanLineVO cockpitPlanLineVO = new CockpitPlanLineVO();
        List<CockpitPlanAreaLineVO> cockpitPlanAreaLineVOList = new ArrayList<>();
        List<CockpitPlanSuperviseTypeLineVO> cockpitPlanSuperviseTypeLineVOList = new ArrayList<>();
        //巡查任务走势图按区县
        for(CockpitAreaVO cockpitAreaVO : cockpitAreaVOs){
            String areaTag = cockpitAreaVO.getAreaTag();
            String areaName = cockpitAreaVO.getAreaName();
            CockpitPlanAreaLineVO cockpitPlanAreaLineVO = new CockpitPlanAreaLineVO();
            cockpitPlanAreaLineVO.setAreaTag(areaTag);
            cockpitPlanAreaLineVO.setAreaName(areaName);
            cockpitPlanAreaLineVO.setFinishTaskNum(cockpitPlanTaskDao.selectCockpitPlanAreaLine(areaTag));
            cockpitPlanAreaLineVOList.add(cockpitPlanAreaLineVO);
        }
        cockpitPlanLineVO.setCockpitPlanAreaLineVOList(cockpitPlanAreaLineVOList);
        //巡查任务走势图按类型
        for(CockpitSuperviseTypeVO cockpitSuperviseTypeVO : cockpitSuperviseTypeVOS){
            String superviseTypeTag = cockpitSuperviseTypeVO.getSuperviseTypeTag();
            String superviseTypeName = cockpitSuperviseTypeVO.getSuperviseTypeName();
            CockpitPlanSuperviseTypeLineVO cockpitPlanSuperviseTypeLineVO = new CockpitPlanSuperviseTypeLineVO();
            cockpitPlanSuperviseTypeLineVO.setSuperviseTypeTag(superviseTypeTag);
            cockpitPlanSuperviseTypeLineVO.setSuperviseTypeName(superviseTypeName);
            cockpitPlanSuperviseTypeLineVO.setFinishTaskNum(cockpitPlanTaskDao.selectCockpitPlanSuperviseTypeLine(superviseTypeTag));
            cockpitPlanSuperviseTypeLineVOList.add(cockpitPlanSuperviseTypeLineVO);
        }
        cockpitPlanLineVO.setCockpitPlanSuperviseTypeLineVOList(cockpitPlanSuperviseTypeLineVOList);
        cockpitPlanTaskVO.setCockpitPlanLine(cockpitPlanLineVO);

        return ResponseEntity.ok(Result.data(cockpitPlanTaskVO));
    }
}
