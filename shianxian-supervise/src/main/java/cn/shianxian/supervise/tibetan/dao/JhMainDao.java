package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.tibetan.pojo.JhSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JhMainDao {

    /**
     * 根据进货客户编码查询进货批次号
     * @param jhkhdm
     * @return
     */
    String selectPurchaseDm(@Param("jhkhdm") String jhkhdm);

    /**
     * 根据进货客户编码和进货批次号查询进货信息，并排序
     * @param jhkhdm
     * @param jhdm
     * @return
     */
    List<JhSub> selectPurchaseInfo(String jhkhdm,String jhdm, Pages pages);
}
