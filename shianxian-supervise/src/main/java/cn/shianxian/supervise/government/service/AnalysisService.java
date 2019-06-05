package cn.shianxian.supervise.government.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface AnalysisService {

    /**
     * 以月度为单位，展示本企业综合评分趋势
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectCompanyLine(QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据(企业雷达图)
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectCompanyRadar(QueryPojo queryPojo);


    /**
     * 以月度为单位，展示本行业综合评分趋势
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectIndustryLine(QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据(行业雷达图)
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectIndustryRadar(QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectAnalysisNodeInfo(QueryPojo queryPojo);


    /**
     * 时间段内企业综合评分排行情况。如企业非前5排行：显示前5企业+本企业开始的5家排行;如企业是前5排行：直接显示TOP10排行
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectAnalysisScore(QueryPojo queryPojo);
}
