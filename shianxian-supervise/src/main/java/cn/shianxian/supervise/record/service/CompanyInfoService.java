package cn.shianxian.supervise.record.service;


import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import org.springframework.http.ResponseEntity;

public interface CompanyInfoService {


    /**
     * 保存企业审核表
     *
     * @param companyInfoForaduit
     * @return
     */
    ResponseEntity<Result> saveCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit);


    /**
     * 修改企业审核表
     * @param companyInfoForaduit
     * @return
     */
    ResponseEntity<Result> updateCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit);


    /**
     * 审核企业
     * @param index
     * @return
     */
    ResponseEntity<Result> checkCompanyInfoForaduit(String index);


    /**
     * 退回企业提交审核信息
     * @param companyInfoForaduit
     * @return
     */
    ResponseEntity<Result> backCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit);


    /**
     * 对企业审核表进行删除申请
     * @param id
     * @return
     */
    ResponseEntity<Result> deleteCompanyInfoForaduit(String id);


    /**
     * 模糊查询企业审核表
     * @param companyInfoForaduit
     * @return
     */
    ResponseEntity<Result> selectCompanyInfoForaduitByLike(CompanyInfoForaduit companyInfoForaduit, Pages pages);


    /**
     * 根据id或企业流水号查询企业审核表
     * @param companyInfoForaduit
     * @return
     */
    ResponseEntity<Result> selectCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit);


    /**
     * 模糊查询企业表
     * @param companyInfo
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectCompanyInfoByLike(CompanyInfo companyInfo, Pages pages);


    /**
     * 根据id查询企业表
     * @param nodeTag
     * @return
     */
    ResponseEntity<Result> selectCompanyInfoById(String nodeTag);


    /**
     * 删除企业表
     * @param index
     * @return
     */
    ResponseEntity<Result> deleteCompanyInfo(String index);
}
