package cn.shianxian.supervise.government.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(message = "政企互动标题过长！", max = 200)
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
    @Size(message = "政企互动内容过长！", max = 2000)
    private String content;

    /**
     * 是否置顶
     */
    @Column(name = "`ifTop`")
    @Size(message = "是否置顶过长！", max = 1)
    private String ifTop;

    /**
     * 是否启用
     */
    @Column(name = "`ifDisable`")
    @Size(message = "是否启用过长！", max = 1)
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
    @Size(message = "栏目标识过长！", max = 50)
    private Long columnTag;

    /**
     * 对象用户标识(暂不用)
     */
    @Column(name = "`userId`")
    @Size(message = "对象用户标识过长！", max = 50)
    private String userId;

    /**
     * 对象用户组标识(暂不用)
     */
    @Column(name = "`userGroupId`")
    @Size(message = "对对象用户组标识过长！", max = 50)
    private String userGroupId;

    /**
     * 栏目名称
     */
    @Transient
    private String columnName;
}
