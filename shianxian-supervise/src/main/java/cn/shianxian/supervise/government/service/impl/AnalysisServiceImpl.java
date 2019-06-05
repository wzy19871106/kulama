package cn.shianxian.supervise.government.service.impl;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.dao.AnalysisDao;
import cn.shianxian.supervise.government.vo.Analysis;
import cn.shianxian.supervise.government.vo.NodeAnalysis;
import cn.shianxian.supervise.government.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {


    @Autowired
    private AnalysisDao analysisDao;


    @Override
    public ResponseEntity<Result> selectCompanyLine(QueryPojo queryPojo) {
        Double avg = this.analysisDao.selectCompanyLine(queryPojo);
        return ResponseEntity.ok(Result.data(avg));
    }


    @Override
    public ResponseEntity<Result> selectCompanyRadar(QueryPojo queryPojo) {
        Analysis analysis = this.analysisDao.selectCompanyRadar(queryPojo);
        return ResponseEntity.ok(Result.data(analysis));
    }


    @Override
    public ResponseEntity<Result> selectIndustryLine(QueryPojo queryPojo) {
        Double avg = this.analysisDao.selectIndustryLine(queryPojo);
        return ResponseEntity.ok(Result.data(avg));
    }


    @Override
    public ResponseEntity<Result> selectIndustryRadar(QueryPojo queryPojo) {
        Analysis analysis = this.analysisDao.selectIndustryRadar(queryPojo);
        return ResponseEntity.ok(Result.data(analysis));
    }


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

}
