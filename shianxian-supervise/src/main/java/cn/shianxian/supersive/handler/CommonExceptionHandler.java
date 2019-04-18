package cn.shianxian.supersive.handler;

import cn.shianxian.supersive.common.pojo.Result;
import cn.shianxian.supersive.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public ResponseEntity<Result> handlerException(CommonException e){
        log.error("捕捉到异常：{}", e.getMsg(), e);
        return ResponseEntity.status(e.getCode()).body(Result.msg(e.getMsg()));
    }

}