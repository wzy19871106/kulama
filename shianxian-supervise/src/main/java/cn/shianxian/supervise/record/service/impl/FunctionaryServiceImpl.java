package cn.shianxian.supervise.record.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.dao.FunctionaryForaduitDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import cn.shianxian.supervise.record.service.FunctionaryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FunctionaryServiceImpl implements FunctionaryService {


    @Autowired
    private FunctionaryForaduitDao functionaryForaduitDao;


    @Autowired
    private FunctionaryDao functionaryDao;


    @Override
    public ResponseEntity<Result> appLogin(String id) {
        Functionary functionary = new Functionary();
        functionary.setWeChatId(id);
        List<Functionary> functionaryList = this.functionaryDao.select(functionary);
        if (1 == functionaryList.size()) {
            functionary = functionaryList.get(0);
            log.info("用户：{}登录", functionary);
        } else {
            functionary.setKeyUsed(0);
        }
        return ResponseEntity.ok(Result.data(functionary));
    }


    @Transactional
    @Override
    public ResponseEntity<Result> saveFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        String flag = this.functionaryForaduitDao.saveFunctionaryForaduit(functionaryForaduit);
        if ("A002".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("该企业的负责人身份证已存在！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> updateFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        this.functionaryForaduitDao.updateFunctionaryForaduit(functionaryForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> checkFunctionaryForaduit(String index) {
        this.functionaryForaduitDao.checkFunctionaryForaduit(index);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> backFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        this.functionaryForaduitDao.backFunctionaryForaduit(functionaryForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryForaduitByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.functionaryForaduitDao.selectFunctionaryForaduitByLike(queryPojo, pages);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        if (StringUtils.isNotBlank(functionaryForaduit.getNodeTag())) {
            functionaryForaduit = this.functionaryForaduitDao.selectFunctionaryForaduitById(functionaryForaduit.getNodeTag());
        } else if (null != functionaryForaduit.getIndex()) {
            functionaryForaduit = this.functionaryForaduitDao.selectFunctionaryForaduitByIndex(functionaryForaduit.getIndex());
        }
        return ResponseEntity.ok(Result.data(functionaryForaduit));
    }


    @Override
    public ResponseEntity<Result> deleteFunctionaryForaduit(String id) {
        String flag = this.functionaryForaduitDao.deleteFunctionaryForaduit(id);
        if ("R003".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("拒绝删除申请！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.functionaryDao.selectFunctionaryByLike(queryPojo, pages);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectFunctionary(Functionary functionary) {
        if (StringUtils.isNotBlank(functionary.getNodeTag())) {
            functionary = this.functionaryDao.selectFunctionaryByNodeTag(functionary.getNodeTag());
        } else if (null != functionary.getFunctionaryTag()) {
            functionary = this.functionaryDao.selectFunctionaryByFunctionaryTag(functionary.getFunctionaryTag());
        } else if (null != functionary.getWeChatId()) {
            functionary = this.functionaryDao.selectFunctionaryByWeChatId(functionary.getWeChatId());
        }
        return ResponseEntity.ok(Result.data(functionary));
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteFunctionary(String index) {
        String flag = this.functionaryDao.deleteFunctionary(index);
        if ("R003".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }
}
