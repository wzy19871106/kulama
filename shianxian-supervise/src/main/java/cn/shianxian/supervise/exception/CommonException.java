package cn.shianxian.supervise.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class CommonException extends RuntimeException {

    private int code;

    private String msg;

    public CommonException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}