package cn.shianxian.supervise.tibetan.service;

import cn.shianxian.supervise.common.pojo.Result;

public interface JhMainService {
    /**
     * 根据进货客户编码查询进货信息
     * @return
     */
    Result selectPurchaseInfoByjhkhdm(String jhkhdm);
}
