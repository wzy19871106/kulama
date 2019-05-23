package cn.shianxian.supervise.record.service.impl;


import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.CompanyInfoForaduitDao;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import cn.shianxian.supervise.record.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {


    @Autowired
    private CompanyInfoForaduitDao companyInfoForaduitDao;


    @Transactional
    @Override
    public ResponseEntity<Result> saveCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        this.companyInfoForaduitDao.saveCompanyInfoForaduit(companyInfoForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> updateCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        this.companyInfoForaduitDao.updateCompanyInfoForaduit(companyInfoForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> checkCompanyInfoForaduit(String index) {
        this.companyInfoForaduitDao.checkCompanyInfoForaduit(index);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> backCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        this.companyInfoForaduitDao.backCompanyInfoForaduit(companyInfoForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }
}
