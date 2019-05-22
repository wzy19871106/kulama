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
}
