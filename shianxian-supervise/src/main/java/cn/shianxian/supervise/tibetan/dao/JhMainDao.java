package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.tibetan.pojo.JhSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JhMainDao {

    /**
     * 根据进货客户编码查询进货信息
     * @param jhkhdm
     * @return
     */
    List<JhSub> selectPurchaseInfo(@Param("jhkhdm") String jhkhdm);
}
