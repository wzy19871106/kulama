package cn.shianxian.supervise.record.service.impl;


import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.CompanyInfoForaduitDao;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import cn.shianxian.supervise.record.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {


    @Autowired
    private CompanyInfoForaduitDao companyInfoForaduitDao;


    @Override
    public ResponseEntity<Result> saveCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        this.companyInfoForaduitDao.saveCompanyInfoForaduit(companyInfoForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }
}
