package cn.shianxian.supervise.record.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.Functionary;
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
     * 根据各种查询条件查询负责人审核表
     * @param queryPojo
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectFunctionaryForaduitByLike(QueryPojo queryPojo, Pages pages);


    /**
     * 根据企业标识查询负责人审核表
     * @return
     */
    ResponseEntity<Result> selectFunctionaryForaduitByNodeTag(String nodeTag, Pages pages);


    /**
     * 根据参数对负责人审核表进行删除申请
     * @param id
     * @return
     */
    ResponseEntity<Result> deleteFunctionaryForaduit(String id);


    /**
     * 根据各种查询条件查询负责人
     * @param queryPojo
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectFunctionaryByLike(QueryPojo queryPojo, Pages pages);


    /**
     * 根据负责人标识、微信id查询负责人
     * @param functionary
     * @return
     */
    ResponseEntity<Result> selectFunctionary(Functionary functionary);


    /**
     * 根据节点流水号删除负责人申请
     * @param index
     * @return
     */
    ResponseEntity<Result> deleteFunctionary(String index);


    /**
     * 保存企业负责人
     * @param functionary
     * @return
     */
    ResponseEntity<Result> saveFunctionary(Functionary functionary);


    /**
     * 根据企业流水号查询负责人审核表
     * @param index
     * @return
     */
    ResponseEntity<Result> selectFunctionaryForaduitByIndex(Long index);


    /**
     * 根据企业标识查询负责人
     * @param nodeTag
     * @return
     */
    ResponseEntity<Result> selectFunctionaryByNodeTag(String nodeTag, Pages pages);


    /**
     * 根据负责人ID更新负责人信息表
     * @param functionaryTag
     * @param weChatId
     * @return
     */
    ResponseEntity<Result> updateWeChatIdById(String functionaryTag, String weChatId);
}
