package cn.shianxian.supervise.record.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.service.FunctionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FunctionaryServiceImpl implements FunctionaryService {


    @Autowired
    private FunctionaryDao functionaryDao;

    @Override
    public ResponseEntity<Result> appLogin(String id) {
        Functionary functionary = new Functionary();
        functionary.setWeChatId(id);
        List<Functionary> functionaryList = this.functionaryDao.select(functionary);
        if (1 == functionaryList.size()) {
            Functionary loginUser = functionaryList.get(0);
            log.info("用户：{}登录", loginUser);
            return ResponseEntity.ok(Result.data(loginUser));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.msg("微信没有绑定！"));
    }
}
