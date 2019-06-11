package cn.shianxian.supervise.government.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.government.vo.AnalysisVO;
import cn.shianxian.supervise.government.vo.NodeAnalysisVO;
import cn.shianxian.supervise.government.vo.PieVO;
import cn.shianxian.supervise.government.vo.TypeColumnVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisDao {

    /**
     * 以月度为单位，展示本企业综合评分趋势
     *
     * @param queryPojo
     * @return
     */
    Double selectCompanyLine(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据(企业雷达图)
     *
     * @param queryPojo
     * @return
     */
    AnalysisVO selectCompanyRadar(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 以月度为单位，展示本行业综合评分趋势
     *
     * @param queryPojo
     * @return
     */
    Double selectIndustryLine(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据(行业雷达图)
     *
     * @param queryPojo
     * @return
     */
    AnalysisVO selectIndustryRadar(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 根据时间段，企业编码，返回所需汇总数据
     *
     * @param queryPojo
     * @return
     */
    NodeAnalysisVO selectAnalysisNodeInfo(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 时间段内企业综合评分排行情况。如企业非前5排行：显示前5企业+本企业开始的5家排行;如企业是前5排行：直接显示TOP10排行
     *
     * @param queryPojo
     * @return
     */
    List<NodeAnalysisVO> selectAnalysisScore(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 根据监管内容分组查询当年的数据饼图
     * @param queryPojo
     * @return
     */
    List<PieVO> selectPie(@Param("queryPojo") QueryPojo queryPojo);


    /**
     * 监管类型分析
     * @param queryPojo
     * @return
     */
    List<TypeColumnVO> selectTypeColumn(@Param("queryPojo") QueryPojo queryPojo);
}
