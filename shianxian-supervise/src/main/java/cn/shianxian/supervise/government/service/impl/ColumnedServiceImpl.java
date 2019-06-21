package cn.shianxian.supervise.government.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.dao.ColumnedDao;
import cn.shianxian.supervise.government.pojo.Columned;
import cn.shianxian.supervise.government.service.ColumnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColumnedServiceImpl implements ColumnedService {

    @Autowired
    private ColumnedDao columnedDao;


    @Transactional
    @Override
    public ResponseEntity<Result> saveOrUpdateColumned(Columned columned) {
        if (null == columned.getColumnTag()) {
            this.columnedDao.saveColumned(columned);
        } else {
            this.columnedDao.updateColumned(columned);
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteColumned(Long columnTag) {
        this.columnedDao.deleteColumned(columnTag);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectColumned(String name, Pages pages) {
        List<List<?>> list = this.columnedDao.selectColumned(name, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));    }


    @Override
    public ResponseEntity<Result> selectColumnedById(Long columnTag) {
        Columned columned = this.columnedDao.selectColumnedById(columnTag);
        return ResponseEntity.ok(Result.data(columned));    }
}
