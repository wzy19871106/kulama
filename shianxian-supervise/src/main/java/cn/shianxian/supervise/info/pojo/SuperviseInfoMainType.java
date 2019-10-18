package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 线下监管业务类型
 */
@Data
@Table(name = "t_Supervise_Info_Main_Type")
public class SuperviseInfoMainType {

    /**
     * 监管业务(主类型)主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "mainIds")
    @Size(message = "监管业务(主类型编码)过长！", max = 50)
    private String mainIds;

    /**
     * 监管业务(主类型)父ID
     */
    @Column(name = "parentMainIds")
    @Size(message = "监管业务(主类型父编码)过长！", max = 50)
    private String parentMainIds;

    /**
     * 监管业务主键
     */
    @Column(name = "mainId")
    @Size(message = "监管业务主键过长！", max = 50)
    private String mainId;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    @Size(message = "企业编码过长！", max = 60)
    private String nodeTag;

    /**
     * 监管类型编码
     */
    @Column(name = "superviseTypeTag")
    @Size(message = "监管类型编码过长！", max = 50)
    private String superviseTypeTag;

    /**
     * 执法队伍编码
     */
    @Column(name = "superviseTeamTag")
    @Size(message = "执法队伍编码过长！", max = 60)
    private String superviseTeamTag;

    /**
     * 执法队伍名称
     */
    @Column(name = "superviseTeamName")
    @Size(message = "执法队伍名称过长！", max = 100)
    private String superviseTeamName;

    /**
     * 执法人员编码
     */
    @Column(name = "superviserTag")
    @Size(message = "执法人员编码过长！", max = 60)
    private String superviserTag;

    /**
     * 执法人员名称
     */
    @Column(name = "superviserName")
    @Size(message = "执法人员名称过长！", max = 100)
    private String superviserName;

    /**
     * 负责人编码
     */
    @Column(name = "functionaryTag")
    @Size(message = "负责人编码过长！", max = 60)
    private String functionaryTag;

    /**
     * 负责人名称
     */
    @Column(name = "functionaryName")
    @Size(message = "负责人名称过长！", max = 100)
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
    private Boolean ifVisit;

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
