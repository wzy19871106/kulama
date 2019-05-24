package cn.shianxian.supervise.record.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import org.springframework.http.ResponseEntity;

public interface FunctionaryService {

    /**
     * app登录
     * @param id
     * @return
     */
    ResponseEntity<Result> appLogin(String id);


    /**
     * 保存企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    ResponseEntity<Result> saveFunctionaryForaduit(FunctionaryForaduit functionaryForaduit);


    /**
     * 修改企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    ResponseEntity<Result> updateFunctionaryForaduit(FunctionaryForaduit functionaryForaduit);


    /**
     * 审核通过负责人审核信息
     * @param index
     * @return
     */
    ResponseEntity<Result> checkFunctionaryForaduit(String index);


    /**
     * 退回负责人提交审核信息
     * @param functionaryForaduit
     * @return
     */
    ResponseEntity<Result> backFunctionaryForaduit(FunctionaryForaduit functionaryForaduit);


    /**
     * 根据各种查询条件查询负责人
     * @param queryPojo
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectFunctionaryForaduitByLike(QueryPojo queryPojo, Pages pages);
}
