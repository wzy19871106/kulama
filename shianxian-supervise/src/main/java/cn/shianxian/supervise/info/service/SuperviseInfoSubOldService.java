package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSubOld;

public interface SuperviseInfoSubOldService {


    /**
     * 根据所选监管业务编码和监管类型查询监管结果详细信息
     * @param superviseInfoSubOld
     * @return
     */
    Result selectSuperviseInfoOldDetail(SuperviseInfoSubOld superviseInfoSubOld);


    /**
     * 保存线下监管业务从表
     * @param superviseInfoSubOld
     * @return
     */
    Result saveSuperviseInfoSubOld(SuperviseInfoSubOld superviseInfoSubOld);
}
