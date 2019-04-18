package cn.shianxian.supersive.common.constants;

/**
 * 常量
 */
public class Constants {

    /**
     * token
     */
    public static final String SUPERVISE_TOKEN = "supervise-token";

    public static final String SUCCESS = "成功";

    public static final String FAIL = "失败";

    public static final int ONE = 1;

    public static final int ZERO = 0;

    /**
     * 状态码========================================================
     */
    public static final int INTERNAL_SERVER_ERROR = 500;

    // 服务不可用
    public static final int GONE = 410;

    // 请求的实体与现有的冲突
    public static final int CONFLICT = 409;

    // 拒绝执行请求
    public static final int FORBIDDEN = 403;

    // 用户验证不通过
    public static final int UNAUTHORIZED = 401;

    // 缺少参数
    public static final int BAD_REQUEST = 400;
    /**
     * 状态码========================================================
     */
}
