package cn.shianxian.supervise.cockpit.dao;

import cn.shianxian.supervise.cockpit.vo.HotpointAreaVO;
import cn.shianxian.supervise.cockpit.vo.HotpointStreetVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotpointDao {
    /**
     * 查询所有区
     *
     * @return
     */
    List<HotpointAreaVO> selectAllArea();

    /**
     * 根据街道标识查询街道名称、坐标及商户数量
     *
     * @param id
     * @return
     */
    List<HotpointStreetVO> selectStreetHotpoint(@Param("id") String id);
}
