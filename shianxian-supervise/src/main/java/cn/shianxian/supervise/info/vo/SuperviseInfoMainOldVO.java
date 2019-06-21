package cn.shianxian.supervise.info.vo;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * 线下监管业务主表VO
 */
@Data
public class SuperviseInfoMainOldVO {

    /**
     * 监管业务主键
     */
    private String mainId;

    /**
     * 企业名称
     */
    private String nodeName;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 监管日期
     */
    private LocalDateTime createTime;

    /**
     * 状态
     */
    private String status;


}
