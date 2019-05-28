package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface FunctionaryForaduitDao extends Mapper<FunctionaryForaduit> {


    /**
     * 保存企业负责人审核表
     * @param functionaryForaduit
     */
    String saveFunctionaryForaduit(@Param("functionaryForaduit") FunctionaryForaduit functionaryForaduit);


    /**
     * 修改企业负责人审核表
     * @param functionaryForaduit
     * @return
     */
    String updateFunctionaryForaduit(@Param("functionaryForaduit") FunctionaryForaduit functionaryForaduit);

    /**
     * 审核通过负责人审核信息
     * @param index
     * @return
     */
    String checkFunctionaryForaduit(@Param("index") String index);


    /**
     * 退回负责人提交审核信息
     * @param functionaryForaduit
     */
    String backFunctionaryForaduit(@Param("functionaryForaduit") FunctionaryForaduit functionaryForaduit);


    /**
     * 根据各种查询条件查询负责人审核表
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectFunctionaryForaduitByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 根据id查询负责人审核表
     * @param nodeTag
     * @return
     */
    List<FunctionaryForaduit> selectFunctionaryForaduitById(@Param("nodeTag") String nodeTag);


    /**
     * 根据企业流水号查询负责人审核表
     * @param index
     * @return
     */
    List<FunctionaryForaduit> selectFunctionaryForaduitByIndex(@Param("index") Long index);


    /**
     * 根据参数对负责人审核表进行删除申请
     * @param id
     */
    String deleteFunctionaryForaduit(@Param("id") String id);

}
