package cn.shianxian.supervise.cockpit.dao;

import cn.shianxian.supervise.cockpit.vo.CockpitAreaVO;
import cn.shianxian.supervise.cockpit.vo.CockpitAssessRadarActualAreaScoreVO;
import cn.shianxian.supervise.cockpit.vo.CockpitSuperviseTypeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CockpitAssessDao {

    /**
     * 查询所有参加考核评议的区县
     * @return
     */
    List<CockpitAreaVO> selectAllArea();

    /**
     * 查询所有参加考核评议的监管类型
     * @return
     */
    List<CockpitSuperviseTypeVO> selectAllSuperviseType();

    /**
     * 查询参加考核评议的监管类型下的所有区县
     * @param id 监管类型编码
     * @return
     */
    List<CockpitAreaVO> selectAllAreaBySuperviseType(@Param("id") String id);

    /**
     * 查询考核评议柱状图和折线图
     * @param areaTag 区县编码
     * @param superviseTypeTag 监管类型编码
     * @param assessType 考核评议类型
     * @return
     */
    List<List<?>> selectAssessLineAndBar(@Param("areaTag") String areaTag, @Param("superviseTypeTag") String superviseTypeTag, @Param("assessType") String assessType);

    /**
     * 查询考核评议雷达图
     * @param areaTag 区县编码
     * @param assessType 考核评议类型
     * @return
     */
    CockpitAssessRadarActualAreaScoreVO selectAssessRadar(@Param("areaTag") String areaTag, @Param("assessType") String assessType);

}
