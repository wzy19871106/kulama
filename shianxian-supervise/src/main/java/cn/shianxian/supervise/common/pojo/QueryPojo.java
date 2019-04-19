package cn.shianxian.supervise.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Date: 2018/11/20 14:33
 * @Description: 查询DTO
 */
@Setter
@Getter
public class QueryPojo {

    /**
     * id
     */
    private String id;

    /**
     * 单号
     */
    private String orderNo;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否有效，1：有效0：无效。
     */
    private String enable;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}
