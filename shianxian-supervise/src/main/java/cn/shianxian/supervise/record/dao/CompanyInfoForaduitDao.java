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
}
