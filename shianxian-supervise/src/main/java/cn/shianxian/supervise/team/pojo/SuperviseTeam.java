package cn.shianxian.supervise.team.pojo;


import cn.shianxian.supervise.common.pojo.BasePojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 执法队伍表
 */
@Data
@Table(name = "t_superviseteam")
public class SuperviseTeam extends BasePojo {


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
