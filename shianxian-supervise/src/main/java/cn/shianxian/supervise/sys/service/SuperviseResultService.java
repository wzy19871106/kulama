package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;

public interface SuperviseResultService {


    /**
     * 保存、修改监管结果
     * @param superviseResult
     * @return
     */
    Result saveSuperviseResult(SuperviseResult superviseResult);


    /**
     * 保存、修改监管结果
     * @param superviseResult
     * @return
     */
    Result updateSuperviseResult(SuperviseResult superviseResult);


    /**
     * 删除监管结果
     * @param ids
     * @return
     */
    Result deleteSuperviseResultById(String ids);


    /**
     * 查询监管结果
     * @param superviseResult
     * @return
     */
    Result selectSuperviseResult(SuperviseResult superviseResult, Pages pages);


    /**
     * 修改监管结果排序
     * @param id
     * @param type
     * @return
     */
    Result updateSuperviseResultBySort(String id, int type);


    /**
     * 根据监管类型返回所有监管选项结果
     * @param typeId
     * @return
     */
    Result selectSuperviseResultByTypeId(String typeId);
}
