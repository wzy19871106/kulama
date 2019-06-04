package cn.shianxian.supervise.government.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * 政企互动信息表
 */
@Table(name = "t_information")
@Data
public class Information {


    /**
     * 政企互动标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`index`")
    private Long index;

    /**
     * 政企互动标题
     */
    @Column(name = "`title`")
    @NotEmpty(message = "标题不能为空！")
    private String title;

    /**
     * 政企互动图片
     */
    @Column(name = "`picTag`")
    private String picTag;

    /**
     * 政企互动内容
     */
    @Column(name = "`content`")
    @NotEmpty(message = "内容不能为空！")
    private String content;

    /**
     * 是否置顶
     */
    @Column(name = "`ifTop`")
    private String ifTop;

    /**
     * 是否启用
     */
    @Column(name = "`ifDisable`")
    private String ifDisable;

    /**
     * 创建时间
     */
    @Column(name = "`createTime`")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "`updateTime`")
    private LocalDateTime updateTime;

    /**
     * 栏目标识
     */
    @Column(name = "`columnTag`")
    private Long columnTag;

    /**
     * 对象用户标识(暂不用)
     */
    @Column(name = "`userId`")
    private String userId;

    /**
     * 对象用户组标识(暂不用)
     */
    @Column(name = "`userGroupId`")
    private String userGroupId;

    /**
     * 栏目名称
     */
    @Transient
    private String columnName;
}
