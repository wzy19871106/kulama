package cn.shianxian.supervise.government.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface AnalysisService {


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


    /**
     * 以月度为单位，展示本企业、本行业综合评分趋势
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectLine(QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据(企业雷达图、行业雷达图)
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectRadar(QueryPojo queryPojo);


    /**
     * 根据监管内容分组查询当年的数据饼图
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectPie(QueryPojo queryPojo);

    /**
     * 根据监管类型分组查询当年的数据饼图
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectPieType(QueryPojo queryPojo);


    /**
     * 监管类型分析
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectTypeColumn(QueryPojo queryPojo);
}
