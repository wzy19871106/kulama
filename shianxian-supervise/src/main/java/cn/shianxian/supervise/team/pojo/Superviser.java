package cn.shianxian.supervise.team.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @Size(message = "执法人员编码过长！", max = 50)
    private String superviserTag;

    /**
     * 执法人员名称
     */
    @Column(name = "`superviserName`")
    @Size(message = "执法人员名称过长！", max = 100)
    private String superviserName;

    /**
     * 执法队伍编码
     */
    @Column(name = "`teamTag`")
    @Size(message = "执法队伍编码过长！", max = 50)
    private String teamTag;

    /**
     * 身份证号码
     */
    @Column(name = "`userNo`")
    @Size(message = "身份证号码过长！", max = 50)
    private String userNo;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    @Size(message = "备注过长！", max = 2000)
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
    @Size(message = "绑定账号过长！", max = 50)
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

    /**
     * 类型1：绑定  2解绑
     */
    @Transient
    private int type;
}
