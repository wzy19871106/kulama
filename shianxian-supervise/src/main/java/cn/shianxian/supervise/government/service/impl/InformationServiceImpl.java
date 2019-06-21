package cn.shianxian.supervise.government.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.dao.InformationDao;
import cn.shianxian.supervise.government.pojo.Information;
import cn.shianxian.supervise.government.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {


    @Autowired
    private InformationDao informationDao;


    @Transactional
    @Override
    public ResponseEntity<Result> saveOrUpdateInformation(Information information) {
        if (null == information.getIndex()) {
            this.informationDao.saveInformation(information);
        } else {
            this.informationDao.updateInformation(information);
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteInformation(Long index) {
        this.informationDao.deleteInformation(index);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectInformation(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.informationDao.selectInformation(queryPojo, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));
    }


    @Override
    public ResponseEntity<Result> selectInformationById(String index) {
        Information information = this.informationDao.selectInformationById(index);
        return ResponseEntity.ok(Result.data(information));
    }


    @Transactional
    @Override
    public ResponseEntity<Result> updateInformationTop(String index, int type) {
        if (1 == type) {
            this.informationDao.updateInformationTop(index);
        } else if (2 ==type) {
            this.informationDao.updateInformationUnTop(index);
        }
        return ResponseEntity.ok(Result.successMsg());
    }
}
