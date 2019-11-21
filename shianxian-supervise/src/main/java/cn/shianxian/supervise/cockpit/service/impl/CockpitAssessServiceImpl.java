package cn.shianxian.supervise.cockpit.service.impl;

import cn.shianxian.supervise.cockpit.dao.CockpitAssessDao;
import cn.shianxian.supervise.cockpit.service.CockpitAssessService;
import cn.shianxian.supervise.cockpit.vo.*;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CockpitAssessServiceImpl implements CockpitAssessService {

    @Autowired
    private CockpitAssessDao cockpitAssessDao;


    @Override
    public ResponseEntity<Result> selectCockpitAssess() {
        //考核评议
        CockpitAssessVO cockpitAssessVO = new CockpitAssessVO();
        List<CockpitAssessNodeVO> cockpitAssessNodeVOList = new ArrayList<>();
        //参与考核评议的区县
        List<CockpitAreaVO> cockpitAreaVOS = cockpitAssessDao.selectAllArea();
        //参与考核评议的监管类型
        List<CockpitSuperviseTypeVO> cockpitSuperviseTypeVOS = cockpitAssessDao.selectAllSuperviseType();
        //商户考核评议
        CockpitAssessNodeVO cockpitAssessCompanyVO = getCockpitAssessNodeVO(cockpitAreaVOS, cockpitSuperviseTypeVOS, "1");
        cockpitAssessNodeVOList.add(cockpitAssessCompanyVO);
        //市场监管人员考核评议
        CockpitAssessNodeVO cockpitAssessSupervisorVO = getCockpitAssessNodeVO(cockpitAreaVOS, cockpitSuperviseTypeVOS, "2");
        cockpitAssessNodeVOList.add(cockpitAssessSupervisorVO);
        //网格员考核评议
        CockpitAssessNodeVO cockpitAssessGridVO = getCockpitAssessNodeVO(cockpitAreaVOS, cockpitSuperviseTypeVOS, "3");
        cockpitAssessNodeVOList.add(cockpitAssessGridVO);
        cockpitAssessVO.setCockpitAssessNodeVOList(cockpitAssessNodeVOList);

        return ResponseEntity.ok(Result.data(cockpitAssessVO));
    }

    private CockpitAssessNodeVO getCockpitAssessNodeVO(List<CockpitAreaVO> cockpitAreaVOS, List<CockpitSuperviseTypeVO> cockpitSuperviseTypeVOS, String assessType){
        CockpitAssessNodeVO cockpitAssessNodeVO = new CockpitAssessNodeVO();
        //雷达图
        CockpitAssessRadarVO cockpitAssessRadarVO = new CockpitAssessRadarVO();
        //各区县的考核评议的最大值
        List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS;
        if(("1").equals(assessType)){
            cockpitAssessRadarMaxVOS = getCockpitAssessCompanyRadarMaxVOS();
        }else{
            cockpitAssessRadarMaxVOS = getCockpitAssessSupervisorRadarMaxVOS();
        }
        cockpitAssessRadarVO.setCockpitAssessRadarMaxVOList(cockpitAssessRadarMaxVOS);
        //各区县的考核评议的实际值
        List<CockpitAssessRadarActualAreaVO> cockpitAssessRadarActualVOS = new ArrayList<>();
        for (CockpitAreaVO cockpitAreaVO : cockpitAreaVOS) {
            List<Double> scoreList = new ArrayList<>();
            CockpitAssessRadarActualAreaScoreVO cockpitAssessRadarActualAreaScoreVO = cockpitAssessDao.selectAssessRadar(cockpitAreaVO.getAreaTag(), assessType);
            //获取非空属性值
            if(cockpitAssessRadarActualAreaScoreVO != null)
            {
                for(Field field : cockpitAssessRadarActualAreaScoreVO.getClass().getDeclaredFields()) {
                    try {
                        field.setAccessible(true);//在用反射时访问私有变量（private修饰变量）
                        if (field.get(cockpitAssessRadarActualAreaScoreVO) != null && !"".equals(field.get(cockpitAssessRadarActualAreaScoreVO))) {
                            scoreList.add((Double) field.get(cockpitAssessRadarActualAreaScoreVO));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            CockpitAssessRadarActualAreaVO cockpitAssessRadarActualAreaVO = new CockpitAssessRadarActualAreaVO();
            cockpitAssessRadarActualAreaVO.setScoreList(scoreList);
            cockpitAssessRadarActualAreaVO.setAreaName(cockpitAreaVO.getAreaName());
            cockpitAssessRadarActualVOS.add(cockpitAssessRadarActualAreaVO);
        }
        cockpitAssessRadarVO.setCockpitAssessRadarActualVOList(cockpitAssessRadarActualVOS);

        //柱状图、折线图
        CockpitAssessCompositeVO cockpitAssessCompositeVO = new CockpitAssessCompositeVO();
        List<CockpitAssessCompositeSuperviseTypeVO> cockpitAssessCompositeSuperviseTypeVOS= new ArrayList<>();
        for (CockpitSuperviseTypeVO cockpitSuperviseTypeVO : cockpitSuperviseTypeVOS) {
            String superviseTypeTag = cockpitSuperviseTypeVO.getSuperviseTypeTag();
            String superviseTypeName = cockpitSuperviseTypeVO.getSuperviseTypeName();
            CockpitAssessCompositeSuperviseTypeVO cockpitAssessCompositeSuperviseTypeVO = new CockpitAssessCompositeSuperviseTypeVO();
            cockpitAssessCompositeSuperviseTypeVO.setSuperviseTypeTag(superviseTypeTag);
            cockpitAssessCompositeSuperviseTypeVO.setSuperviseTypeName(superviseTypeName);
            List<CockpitAssessCompositeSuperviseTypeAreaVO> cockpitAssessCompositeSuperviseTypeAreaVOS= new ArrayList<>();
            List<CockpitAreaVO> cockpitAreaVOList = cockpitAssessDao.selectAllAreaBySuperviseType(superviseTypeTag);
            for (CockpitAreaVO cockpitAreaVO : cockpitAreaVOList) {
                String areaTag = cockpitAreaVO.getAreaTag();
                String areaName = cockpitAreaVO.getAreaName();
                CockpitAssessCompositeSuperviseTypeAreaVO cockpitAssessCompositeSuperviseTypeAreaVO = new CockpitAssessCompositeSuperviseTypeAreaVO();
                cockpitAssessCompositeSuperviseTypeAreaVO.setAreaTag(areaTag);
                cockpitAssessCompositeSuperviseTypeAreaVO.setAreaName(areaName);
                //柱状图
                List<List<?>> lists = cockpitAssessDao.selectAssessLineAndBar(areaTag, superviseTypeTag, assessType);
                List<Map<String,Double>> maps = (List<Map<String, Double>>) lists.get(0);
                List<List<Object>> cockpitAssessCompositeSuperviseTypeAreaBarList = new ArrayList<>();
                for (Map<String,Double> map : maps) {
                    List<Object> objects = new ArrayList<>();
                    for(Map.Entry<String, Double> vo : map.entrySet()) {
                        objects.add(vo.getValue());
                    }
                    cockpitAssessCompositeSuperviseTypeAreaBarList.add(objects);
                }
                cockpitAssessCompositeSuperviseTypeAreaVO.setCockpitAssessCompositeSuperviseTypeAreaBarList(cockpitAssessCompositeSuperviseTypeAreaBarList);
                //折线图
                CockpitAssessCompositeSuperviseTypeAreaLineVO cockpitAssessCompositeSuperviseTypeAreaLineVO = new CockpitAssessCompositeSuperviseTypeAreaLineVO();
                cockpitAssessCompositeSuperviseTypeAreaLineVO.setAreaName(areaName);
                cockpitAssessCompositeSuperviseTypeAreaLineVO.setAssessScore((List<Double>) lists.get(1));
                cockpitAssessCompositeSuperviseTypeAreaVO.setCockpitAssessCompositeSuperviseTypeAreaLineVO(cockpitAssessCompositeSuperviseTypeAreaLineVO);
                cockpitAssessCompositeSuperviseTypeAreaVOS.add(cockpitAssessCompositeSuperviseTypeAreaVO);
            }
            cockpitAssessCompositeSuperviseTypeVO.setCockpitAssessCompositeSuperviseTypeAreaVOList(cockpitAssessCompositeSuperviseTypeAreaVOS);
            cockpitAssessCompositeSuperviseTypeVOS.add(cockpitAssessCompositeSuperviseTypeVO);
        }
        cockpitAssessCompositeVO.setCockpitAssessCompositeSuperviseTypeVOList(cockpitAssessCompositeSuperviseTypeVOS);

        cockpitAssessNodeVO.setCockpitAssessRadarVO(cockpitAssessRadarVO);
        cockpitAssessNodeVO.setCockpitAssessCompositeVO(cockpitAssessCompositeVO);

        return cockpitAssessNodeVO;
    }

    private List<CockpitAssessRadarMaxVO> getCockpitAssessCompanyRadarMaxVOS(){
        List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS = new ArrayList<>();
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO = new CockpitAssessRadarMaxVO();
        cockpitAssessRadarMaxVO.setName("备案完整率");
        cockpitAssessRadarMaxVO.setMax(100);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("规范经营情况");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("及时整改率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("问题复现率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("整改完成率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("呼叫响应及时情况");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        return cockpitAssessRadarMaxVOS;
    }

    private List<CockpitAssessRadarMaxVO> getCockpitAssessSupervisorRadarMaxVOS(){
        List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS = new ArrayList<>();
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO = new CockpitAssessRadarMaxVO();
        cockpitAssessRadarMaxVO.setName("计划任务完成率");
        cockpitAssessRadarMaxVO.setMax(100);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("巡查数据完整性");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("数据增长率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("情况及时反馈率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        cockpitAssessRadarMaxVO.setName("巡查次数达标率");
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO);
        return cockpitAssessRadarMaxVOS;
    }

}
