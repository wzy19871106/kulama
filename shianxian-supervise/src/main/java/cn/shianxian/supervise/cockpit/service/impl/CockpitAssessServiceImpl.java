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
import java.util.HashMap;
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
        CockpitSuperviseTypeVO cockpitSuperviseTypeVO = new CockpitSuperviseTypeVO();
        cockpitSuperviseTypeVO.setSuperviseTypeTag("ALL");
        cockpitSuperviseTypeVO.setSuperviseTypeName("全市");
        cockpitSuperviseTypeVOS.add(cockpitSuperviseTypeVO);
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
        //柱状图、折线图、雷达图
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
                List<CockpitAssessCompositeSuperviseTypeAreaBar> cockpitAssessCompositeSuperviseTypeAreaBars = (List<CockpitAssessCompositeSuperviseTypeAreaBar>) lists.get(0);
                cockpitAssessCompositeSuperviseTypeAreaVO.setCockpitAssessCompositeSuperviseTypeAreaBarList(cockpitAssessCompositeSuperviseTypeAreaBars);
                //折线图
                CockpitAssessCompositeSuperviseTypeAreaLineVO cockpitAssessCompositeSuperviseTypeAreaLineVO = new CockpitAssessCompositeSuperviseTypeAreaLineVO();
                List<CockpitAssessCompositeLineVO> cockpitAssessCompositeLineVOS = (List<CockpitAssessCompositeLineVO>) lists.get(1);
                List<Integer> times = new ArrayList<>();
                List<Double> scores = new ArrayList<>();
                for (CockpitAssessCompositeLineVO cockpitAssessCompositeLineVO: cockpitAssessCompositeLineVOS) {
                    times.add(cockpitAssessCompositeLineVO.getAssessTime());
                    scores.add(cockpitAssessCompositeLineVO.getAssessScore());
                }
                cockpitAssessCompositeSuperviseTypeAreaLineVO.setAssessTime(times);
                cockpitAssessCompositeSuperviseTypeAreaLineVO.setAssessScore(scores);
                cockpitAssessCompositeSuperviseTypeAreaVO.setCockpitAssessCompositeSuperviseTypeAreaLineVO(cockpitAssessCompositeSuperviseTypeAreaLineVO);
                //雷达图
                CockpitAssessRadarVO cockpitAssessRadarVO = new CockpitAssessRadarVO();
                //考核评议的最大值
                List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS;
                if(("1").equals(assessType)){
                    cockpitAssessRadarMaxVOS = getCockpitAssessCompanyRadarMaxVOS();
                }else{
                    cockpitAssessRadarMaxVOS = getCockpitAssessSupervisorRadarMaxVOS();
                }
                cockpitAssessRadarVO.setCockpitAssessRadarMaxVOList(cockpitAssessRadarMaxVOS);
                //考核评议的实际值
                List<CockpitAssessRadarActualVO> cockpitAssessRadarActualVOS = new ArrayList<>();
                CockpitAssessRadarActualAreaScoreVO cockpitAssessRadarActualAreaScoreVO = (CockpitAssessRadarActualAreaScoreVO) lists.get(2).get(0);
                //获取非空属性值
                if(cockpitAssessRadarActualAreaScoreVO != null)
                {
                    for(Field field : cockpitAssessRadarActualAreaScoreVO.getClass().getDeclaredFields()) {
                        try {
                            field.setAccessible(true);//在用反射时访问私有变量（private修饰变量）
                            if (field.get(cockpitAssessRadarActualAreaScoreVO) != null && !"".equals(field.get(cockpitAssessRadarActualAreaScoreVO))) {
                                CockpitAssessRadarActualVO cockpitAssessRadarActualVO = new CockpitAssessRadarActualVO();
                                cockpitAssessRadarActualVO.setName(field.getName());
                                cockpitAssessRadarActualVO.setValue((Double) field.get(cockpitAssessRadarActualAreaScoreVO));
                                cockpitAssessRadarActualVOS.add(cockpitAssessRadarActualVO);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                cockpitAssessRadarVO.setCockpitAssessRadarActualVOList(cockpitAssessRadarActualVOS);
                cockpitAssessCompositeSuperviseTypeAreaVO.setCockpitAssessRadarVO(cockpitAssessRadarVO);

                cockpitAssessCompositeSuperviseTypeAreaVOS.add(cockpitAssessCompositeSuperviseTypeAreaVO);
            }
            cockpitAssessCompositeSuperviseTypeVO.setCockpitAssessCompositeSuperviseTypeAreaVOList(cockpitAssessCompositeSuperviseTypeAreaVOS);
            cockpitAssessCompositeSuperviseTypeVOS.add(cockpitAssessCompositeSuperviseTypeVO);
        }
        cockpitAssessCompositeVO.setCockpitAssessCompositeSuperviseTypeVOList(cockpitAssessCompositeSuperviseTypeVOS);

        cockpitAssessNodeVO.setCockpitAssessCompositeVO(cockpitAssessCompositeVO);

        return cockpitAssessNodeVO;
    }

    private List<CockpitAssessRadarMaxVO> getCockpitAssessCompanyRadarMaxVOS(){
        List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS = new ArrayList<>();
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO1 = new CockpitAssessRadarMaxVO("备案完整率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO1);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO2 = new CockpitAssessRadarMaxVO("规范经营情况",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO2);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO3 = new CockpitAssessRadarMaxVO("及时整改率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO3);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO4 = new CockpitAssessRadarMaxVO("问题复现率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO4);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO5 = new CockpitAssessRadarMaxVO("整改完成率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO5);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO6 = new CockpitAssessRadarMaxVO("呼叫响应及时情况",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO6);
        return cockpitAssessRadarMaxVOS;
    }

    private List<CockpitAssessRadarMaxVO> getCockpitAssessSupervisorRadarMaxVOS(){
        List<CockpitAssessRadarMaxVO> cockpitAssessRadarMaxVOS = new ArrayList<>();
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO1 = new CockpitAssessRadarMaxVO("计划任务完成率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO1);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO2 = new CockpitAssessRadarMaxVO("巡查数据完整性",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO2);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO3 = new CockpitAssessRadarMaxVO("数据增长率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO3);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO4 = new CockpitAssessRadarMaxVO("情况及时反馈率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO4);
        CockpitAssessRadarMaxVO cockpitAssessRadarMaxVO5 = new CockpitAssessRadarMaxVO("巡查次数达标率",100d);
        cockpitAssessRadarMaxVOS.add(cockpitAssessRadarMaxVO5);
        return cockpitAssessRadarMaxVOS;
    }

}
