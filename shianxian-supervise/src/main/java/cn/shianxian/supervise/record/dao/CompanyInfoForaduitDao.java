package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

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
}
