package cn.shianxian.supervise.team.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 执法队伍表
 */
@Data
@Table(name = "t_superviseteam")
public class SuperviseTeam {


    /**
     * 执法队伍编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`teamTag`")
    private String teamTag;

    /**
     * 执法队伍名称
     */
    @Column(name = "`teamName`")
    private String teamName;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 是否启用
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
     * 位置
     */
    @Column(name = "`order`")
    private String order;

    /**
     * 逻辑删除
     */
    @Column(name = "`ifDelete`")
    private Boolean ifDelete;

}
