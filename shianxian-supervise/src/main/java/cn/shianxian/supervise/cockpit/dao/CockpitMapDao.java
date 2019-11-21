package cn.shianxian.supervise.cockpit.dao;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CockpitMapDao {
    /**
     * 根据监管类型以及考核周期查询驾驶舱地图页面的数据
     *
     * @return
     */
    List<List<?>> selectCockpitMap(@Param("queryPojo") QueryPojo queryPojo);

}
