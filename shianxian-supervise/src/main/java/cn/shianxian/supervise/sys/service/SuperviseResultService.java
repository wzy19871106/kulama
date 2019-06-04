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
    Result updateSuperviseResultBySort(String id, int type);


    /**
     * 查询监管结果（树）
     * @param typeTag
     * @param authority
     * @return
     */
    Result selectSuperviseResultTree(String typeTag, String authority);
}
