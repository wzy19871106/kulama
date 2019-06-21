package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CompanyInfoForaduitDao extends Mapper<CompanyInfoForaduit> {


    /**
     * 保存企业审核表
     * @param companyInfoForaduit
     * @return
     */
    String saveCompanyInfoForaduit(@Param("companyInfoForaduit") CompanyInfoForaduit companyInfoForaduit);


    /**
     * 修改企业审核表
     * @param companyInfoForaduit
     * @return
     */
    String updateCompanyInfoForaduit(@Param("companyInfoForaduit") CompanyInfoForaduit companyInfoForaduit);


    /**
     * 审核企业
     * @param index
     */
    String checkCompanyInfoForaduit(@Param("index") String index);


    /**
     * 退回企业提交审核信息
     * @param companyInfoForaduit
     */
    String backCompanyInfoForaduit(@Param("companyInfoForaduit") CompanyInfoForaduit companyInfoForaduit);


    /**
     * 对企业审核表进行删除申请
     * @param id
     */
    String deleteCompanyInfoForaduit(@Param("id") String id);


    /**
     * 模糊查询企业审核表
     * @param companyInfoForaduit
     * @param pages
     * @return
     */
    List<List<?>> selectCompanyInfoForaduitByLike(@Param("companyInfoForaduit") CompanyInfoForaduit companyInfoForaduit, @Param("pages") Pages pages);


    /**
     * 根据id查询企业审核表
     * @param nodeTag
     * @return
     */
    CompanyInfoForaduit selectCompanyInfoForaduitById(@Param("nodeTag") String nodeTag);


    /**
     * 根据企业流水号查询企业审核表
     * @param index
     * @return
     */
    CompanyInfoForaduit selectCompanyInfoForaduitByIndex(@Param("index") Long index);


    /**
     * 根据企业id查询企业、负责人审核表
     * @param nodeTag
     * @param pages
     * @return
     */
    List<List<?>> selectCompanyInfoFunctionaryForAduit(@Param("nodeTag") String nodeTag, @Param("pages") Pages pages);
}
