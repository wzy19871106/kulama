package cn.shianxian.supervise.government.service.impl;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.DateUtils;
import cn.shianxian.supervise.government.dao.AnalysisDao;
import cn.shianxian.supervise.government.service.AnalysisService;
import cn.shianxian.supervise.government.vo.Analysis;
import cn.shianxian.supervise.government.vo.NodeAnalysis;
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
        NodeAnalysis nodeAnalysis = this.analysisDao.selectAnalysisNodeInfo(queryPojo);
        return ResponseEntity.ok(Result.data(nodeAnalysis));
    }


    @Override
    public ResponseEntity<Result> selectAnalysisScore(QueryPojo queryPojo) {
        List<NodeAnalysis> list = this.analysisDao.selectAnalysisScore(queryPojo);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectLine(QueryPojo queryPojo) {
        Map<String, Object> map = new HashMap<>();
        LocalDateTime startTime = queryPojo.getStartTime();
        LocalDateTime endTime = queryPojo.getEndTime();
        startTime.plusMonths(1);
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
            Double avgIndustry = this.analysisDao.selectIndustryLine(queryPojo);
            companyList.add(avgCompany);
            industryList.add(avgIndustry);
            monthList.add(DateUtils.yyyyMMddFormat(tempStartTime.toLocalDate()));
        }
        map.put("company", companyList);
        map.put("industry", industryList);
        map.put("month", monthList);
        return ResponseEntity.ok(Result.data(map));
    }


    @Override
    public ResponseEntity<Result> selectRadar(QueryPojo queryPojo) {
        Analysis company = this.analysisDao.selectCompanyRadar(queryPojo);
        Analysis industry = this.analysisDao.selectIndustryRadar(queryPojo);
        Map<String, Object> map = new HashMap<>();
        map.put("company", company);
        map.put("industry", industry);
        return ResponseEntity.ok(Result.data(map));
    }


}
