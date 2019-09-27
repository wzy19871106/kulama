package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import org.springframework.http.ResponseEntity;

public interface SuperviseResultService {


    /**
     * 保存、修改监管结果
     * @param superviseResult
     * @return
     */
    ResponseEntity<Result> saveSuperviseResult(SuperviseResult superviseResult);


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
    ResponseEntity<Result> deleteSuperviseResultById(String ids);


    /**
     * 查询监管结果
     * @param superviseResult
     * @return
     */
    Result selectSuperviseResult(SuperviseResult superviseResult);


    /**
     * 修改监管结果排序
     * @param id
     * @param type
     * @return
     */
    ResponseEntity<Result> updateSuperviseResultBySort(String id, int type);


    /**
     * 查询监管结果（树）
     * @param typeTag
     * @param authority
     * @return
     */
    Result selectSuperviseResultTree(String typeTag, String authority);


    /**
     * 查询整改反馈监管结果（树）
     * @param mainIds
     * @return
     */
    Result selectSuperviseResultRectifyTree(String mainIds);

    /**
     * 根据监管内容编码查询满分的监管结果
     * @param id
     * @return
     */
    Result selectSuperviseFullResultById(String id);


    /**
     * 根据监管内容编码查询最低分的监管结果
     * @param id
     * @return
     */
    Result selectSuperviseWorstResultById(String id);
}
