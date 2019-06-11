package cn.shianxian.supervise.government.service.impl;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.DateUtils;
import cn.shianxian.supervise.government.dao.AnalysisDao;
import cn.shianxian.supervise.government.service.AnalysisService;
import cn.shianxian.supervise.government.vo.AnalysisVO;
import cn.shianxian.supervise.government.vo.NodeAnalysisVO;
import cn.shianxian.supervise.government.vo.PieVO;
import cn.shianxian.supervise.government.vo.TypeColumnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalysisServiceImpl implements AnalysisService {


    @Autowired
    private AnalysisDao analysisDao;


    @Override
    public ResponseEntity<Result> selectAnalysisNodeInfo(QueryPojo queryPojo) {
        NodeAnalysisVO nodeAnalysis = this.analysisDao.selectAnalysisNodeInfo(queryPojo);
        return ResponseEntity.ok(Result.data(nodeAnalysis));
    }


    @Override
    public ResponseEntity<Result> selectAnalysisScore(QueryPojo queryPojo) {
        List<NodeAnalysisVO> list = this.analysisDao.selectAnalysisScore(queryPojo);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectLine(QueryPojo queryPojo) {
        Map<String, Object> map = new HashMap<>();
        LocalDateTime startTime = queryPojo.getStartTime();
        LocalDateTime endTime = queryPojo.getEndTime();
        List<Double> companyList = new ArrayList<>();
        List<Double> industryList = new ArrayList<>();
        List<String> monthList = new ArrayList<>();
        // 获取两个月份之差
        int monthNum = DateUtils.getMonthNum(startTime, endTime);
        for (int i = 0; i <= monthNum; i++) {
            LocalDateTime tempStartTime = startTime.plusMonths(i);
            queryPojo.setStartTime(tempStartTime);
            LocalDateTime tempEndTime = startTime.plusMonths(i + 1);
            queryPojo.setEndTime(tempEndTime);
            Double avgCompany = this.analysisDao.selectCompanyLine(queryPojo);
            if (avgCompany == null) {
                companyList.add(0.0);
            } else {
                companyList.add(avgCompany);
            }
            Double avgIndustry = this.analysisDao.selectIndustryLine(queryPojo);
            if (avgIndustry == null) {
                industryList.add(0.0);
            } else {
                industryList.add(avgIndustry);
            }
            monthList.add(DateUtils.yyyyMMddFormat(tempStartTime.toLocalDate()));
        }
        map.put("company", companyList);
        map.put("industry", industryList);
        map.put("month", monthList);
        return ResponseEntity.ok(Result.data(map));
    }


    @Override
    public ResponseEntity<Result> selectRadar(QueryPojo queryPojo) {
        AnalysisVO company = this.analysisDao.selectCompanyRadar(queryPojo);
        AnalysisVO industry = this.analysisDao.selectIndustryRadar(queryPojo);
        Map<String, Object> map = new HashMap<>();
        map.put("company", company);
        map.put("industry", industry);
        return ResponseEntity.ok(Result.data(map));
    }


    @Override
    public ResponseEntity<Result> selectPie(QueryPojo queryPojo) {
        List<PieVO> list = this.analysisDao.selectPie(queryPojo);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectTypeColumn(QueryPojo queryPojo) {
        List<TypeColumnVO> list = this.analysisDao.selectTypeColumn(queryPojo);
        return ResponseEntity.ok(Result.data(list));
    }


}
