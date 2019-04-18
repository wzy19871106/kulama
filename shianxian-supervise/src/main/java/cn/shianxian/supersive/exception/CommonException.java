package cn.shianxian.supersive.exception;

import cn.shianxian.supersive.common.constants.Constants;
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

    public CommonException() {
        this.code = Constants.INTERNAL_SERVER_ERROR;
        this.msg = super.getMessage();
    }

    public CommonException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}