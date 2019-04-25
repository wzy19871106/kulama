package cn.shianxian.supervise.team.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 执法人员表
 */
@Data
@Table(name = "t_superviser")
public class Superviser {


    /**
     * 执法人员编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`superviserTag`")
    private String superviserTag;

    /**
     * 执法人员名称
     */
    @Column(name = "`superviserName`")
    private String superviserName;

    /**
     * 执法队伍编码
     */
    @Column(name = "`teamTag`")
    private String teamTag;

    /**
     * 身份证号码
     */
    @Column(name = "`userNo`")
    private String userNo;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 是否使用
     */
    @Column(name = "`ifUse`")
    private Boolean ifUse;

    /**
     * 创建时间
     */
    @Column(name = "`createTime`")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "`createUser`")
    private String createUser;

    /**
     * 最后更新日期
     */
    @Column(name = "`lastUpdateTime`")
    private LocalDateTime lastUpdateTime;

    /**
     * 最后更新人
     */
    @Column(name = "`lastUpdateUser`")
    private String lastUpdateUser;

    /**
     * 图片信息
     */
    @Column(name = "`picTag`")
    private String picTag;

    /**
     * 绑定账号
     */
    @Column(name = "`userTag`")
    private String userTag;

    /**
     * 逻辑删除
     */
    @Column(name = "`ifDelete`")
    private Boolean ifDelete;


}
