package cn.shianxian.supervise.push.vo;

import lombok.Data;

/**
 * 极光推送
 */
@Data
public class JpushVO {

    /**
     * registrationId指定用户
     */
    private String id;

    /**
     * 推送主题
     */
    private String title;

    /**
     * 自定义推送内容
     */
    private String msg;

    /**
     * 别名
     */
    private String alias;
}
