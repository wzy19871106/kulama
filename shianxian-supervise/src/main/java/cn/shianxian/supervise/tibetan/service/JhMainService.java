package cn.shianxian.supervise.tibetan.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;

public interface JhMainService {
    /**
     * 根据进货客户编码查询进货批次号
     * @return
     */
    Result selectPurchaseDmByjhkhdm(String jhkhdm);

    /**
     * 根据进货客户编码和进货批次号查询进货信息，并排序
     * @return
     */
    Result selectPurchaseInfoByjhdm(String jhkhdm, String jhdm, Pages pages);
}
