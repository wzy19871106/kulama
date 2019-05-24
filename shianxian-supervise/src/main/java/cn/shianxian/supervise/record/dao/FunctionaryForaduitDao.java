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
     * 根据各种查询条件查询负责人
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectFunctionaryForaduitByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);
}
