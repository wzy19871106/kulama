package cn.shianxian.supervise.record.service.impl;


import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.CompanyInfoDao;
import cn.shianxian.supervise.record.dao.CompanyInfoForaduitDao;
import cn.shianxian.supervise.record.pojo.CompanyInfo;
import cn.shianxian.supervise.record.pojo.CompanyInfoForaduit;
import cn.shianxian.supervise.record.service.CompanyInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {


    @Autowired
    private CompanyInfoForaduitDao companyInfoForaduitDao;

    @Autowired
    private CompanyInfoDao companyInfoDao;


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


    @Transactional
    @Override
    public ResponseEntity<Result> deleteCompanyInfoForaduit(String id) {
        String flag = this.companyInfoForaduitDao.deleteCompanyInfoForaduit(id);
        if (!"R001".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("拒绝删除申请！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectCompanyInfoForaduitByLike(CompanyInfoForaduit companyInfoForaduit, Pages pages) {
        List<List<?>> list = this.companyInfoForaduitDao.selectCompanyInfoForaduitByLike(companyInfoForaduit, pages);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectCompanyInfoForaduit(CompanyInfoForaduit companyInfoForaduit) {
        if (StringUtils.isNotBlank(companyInfoForaduit.getNodeTag())) {
            companyInfoForaduit = this.companyInfoForaduitDao.selectCompanyInfoForaduitById(companyInfoForaduit.getNodeTag());
        } else if (null != companyInfoForaduit.getIndex()) {
            companyInfoForaduit = this.companyInfoForaduitDao.selectCompanyInfoForaduitByIndex(companyInfoForaduit.getIndex());
        }
        return ResponseEntity.ok(Result.data(companyInfoForaduit));
    }


    @Override
    public ResponseEntity<Result> selectCompanyInfoByLike(CompanyInfo companyInfo, Pages pages) {
        List<List<?>> list = this.companyInfoDao.selectCompanyInfoByLike(companyInfo, pages);
        return ResponseEntity.ok(Result.data(list));
    }

    @Override
    public ResponseEntity<Result> selectCompanyInfoById(String nodeTag) {
        CompanyInfo companyInfo = this.companyInfoDao.selectCompanyInfoById(nodeTag);
        return ResponseEntity.ok(Result.data(companyInfo));
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteCompanyInfo(String index) {
        String flag = this.companyInfoDao.deleteCompanyInfo(index);
        if (!"R001".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }
}
