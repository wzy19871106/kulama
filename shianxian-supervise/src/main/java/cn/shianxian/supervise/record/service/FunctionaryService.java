package cn.shianxian.supervise.record.service;

import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface FunctionaryService {

    /**
     * app登录
     * @param id
     * @return
     */
    ResponseEntity<Result> appLogin(String id);
}
