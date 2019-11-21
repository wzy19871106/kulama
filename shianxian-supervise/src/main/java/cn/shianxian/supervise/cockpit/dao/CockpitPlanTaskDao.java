package cn.shianxian.supervise.cockpit.dao;

import cn.shianxian.supervise.cockpit.vo.CockpitAreaVO;
import cn.shianxian.supervise.cockpit.vo.CockpitPlanAreaSuperviseTypeCompositeVO;
import cn.shianxian.supervise.cockpit.vo.CockpitSuperviseTypeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CockpitPlanTaskDao {

    /**
     * 查询驾驶舱计划任务页面圆形图、区县、监管所排名的数据
     *
     * @return
     */
    List<List<?>> selectCockpitPlan();

    /**
     * 查询所有区
     *
     * @return
     */
    List<CockpitAreaVO> selectAllArea();

    /**
     * 查询所有监管类型
     *
     * @return
     */
    List<CockpitSuperviseTypeVO> selectAllSuperviseType();

    /**
     * 根据区县编码查询该区县各监管类型的统计数据
     * @param id 区县编码
     * @return
     */
    List<CockpitPlanAreaSuperviseTypeCompositeVO> selectCockpitPlanComposite(@Param("id") String id);

    /**
     * 根据区县编码查询该区县的巡查任务数
     * @param id 区县编码
     * @return
     */
    List<Integer> selectCockpitPlanAreaLine(@Param("id") String id);

    /**
     * 根据监管类型编码查询该监管类型的巡查任务数
     * @param id 监管类型编码
     * @return
     */
    List<Integer> selectCockpitPlanSuperviseTypeLine(@Param("id") String id);

}
