package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;

public interface SuperviseResultService {

    /**
     * 查询监管结果
     * @param superviseResult
     * @return
     */
    Result selectSuperviseResult(SuperviseResult superviseResult);


    /**
     * 保存、修改监管结果
     * @param superviseResult
     * @return
     */
    Result saveOrUpdateSuperviseResult(SuperviseResult superviseResult);


    /**
     * 删除监管结果
     * @param ids
     * @return
     */
    Result deleteSuperviseResultById(String ids);


    /**
     * 修改监管结果排序
     * @param id
     * @param type
     * @return
     */
    Result updateSuperviseResultBySort(String id, int type);
}
