package cn.shianxian.supervise.record.service;


import cn.shianxian.supervise.common.pojo.Result;
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
}
