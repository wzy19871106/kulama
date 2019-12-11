package cn.shianxian.supervise.common.constants;

/**
 * 常量
 */
public class Constants {

    /**
     * token
     */
    public static final String SUPERVISE_TOKEN = "supervise-token";

    public static final String APP_USER = "appUser:";

    public static final String USER = "user:";

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


    /**
     * 监管项状态码=========================================
     */
    public static final String STATUS_NULL = "";
    public static final String STATUS_NOE = "1";
    public static final String STATUS_TWO_THREE = "2,3";
    public static final String STATUS_THREE = "3";
    public static final String STATUS_TWO = "2";
    /**
     * 监管项状态码=========================================
     */

    /**
     * 图片类型=========================================
     */
    public static final String PIC_FACE = "注册人脸";
    public static final String PIC_ID_FONT = "正面";
    public static final String PIC_ID_REVERSE = "反面";
    public static final String PIC_LISENCE = "营业执照";
}
