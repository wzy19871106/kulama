package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CompanyInfoDao extends Mapper<CompanyInfo> {


    /**
     * 模糊查询企业表
     * @param companyInfo
     * @param pages
     * @return
     */
    List<List<?>> selectCompanyInfoByLike(@Param("companyInfo") CompanyInfo companyInfo, @Param("pages") Pages pages);


    /**
     * 根据id查询企业表
     * @param nodeTag
     * @return
     */
    CompanyInfo selectCompanyInfoById(@Param("nodeTag") String nodeTag);


    /**
     * 删除企业表
     * @param index
     * @return
     */
    String deleteCompanyInfo(@Param("index") String index);

}
