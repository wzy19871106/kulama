package cn.shianxian.supervise.team.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.*;

/**
 * 执法人员表
 */
@Data
@Table(name = "t_superviser")
public class Superviser extends BasePojo {


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

    /**
     * 执法队伍名称
     */
    @Transient
    private String teamName;
}
