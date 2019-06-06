package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 线下监管业务类型
 */
@Data
@Table(name = "t_SuperviseInfoMainType")
public class SuperviseInfoMainType {

    /**
     * 监管业务(主类型)主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "mainIds")
    private String mainIds;

    /**
     * 监管业务(主类型)父ID
     */
    @Column(name = "parentMainIds")
    private String parentMainIds;

    /**
     * 监管业务主键
     */
    @Column(name = "mainId")
    private String mainId;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    private String nodeTag;

    /**
     * 监管类型编码
     */
    @Column(name = "superviseTypeTag")
    private String superviseTypeTag;

    /**
     * 执法队伍编码
     */
    @Column(name = "superviseTeamTag")
    private String superviseTeamTag;

    /**
     * 执法队伍名称
     */
    @Column(name = "superviseTeamName")
    private String superviseTeamName;

    /**
     * 执法人员编码
     */
    @Column(name = "superviserTag")
    private String superviserTag;

    /**
     * 执法人员名称
     */
    @Column(name = "superviserName")
    private String superviserName;

    /**
     * 负责人编码
     */
    @Column(name = "functionaryTag")
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Column(name = "functionaryName")
    private String functionaryName;

    /**
     * 监管日期
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 结果分值
     */
    @Column(name = "score")
    private Long score;

    /**
     * 整改状态  0 无需整改 1,2,3,4.....需要整改的数量
     */
    @Column(name = "status")
    private String status;

    /**
     * 回访状态
     */
    @Column(name = "ifVisit")
    private String ifVisit;

    /**
     * 逻辑删除
     */
    @Column(name = "ifDelete")
    private String ifDelete;

    /**
     * 监管子表集合
     */
    @Transient
    List<SuperviseInfoSub> superviseInfoSubs;

}
