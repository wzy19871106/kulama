package cn.shianxian.supervise.info.vo;

import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 整改情况监管结果
 */
@Data
public class RectifyResultVO {

    /**
     * 监管业务id
     */
    private String mainId;

    /**
     * 监管业务类型id
     */
    private String mainIds;

    /**
     * 企业编码
     */
    private String nodeTag;

    /**
     * 企业名称
     */
    private String nodeName;

    /**
     * 监管类型编码
     */
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 结果分值
     */
    private Long score;

    /**
     * 整改状态
     */
    private Long status;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 执法人员名称
     */
    private String superviserName;

    /**
     * 负责人名称
     */
    private String functionaryName;
    /**
     * 执法队伍编码
     */
    private String superviseTeamTag;

    /**
     *执法队伍名称
     */
    private String superviseTeamName;

    /**
     *执法人员编码
     */
    private String superviserTag;

    /**
     *负责人编码
     */
    private String functionaryTag;

    /**
     * 计划任务编号
     */
    private String planTag;

    /**
     * 所有整改项
     */
    private Long allStatus;

    /**
     * （整改回访）已整改项
     */
    private Long completeStatus;

    /**
     * 未整改项
     */
    private Long unCompleteStatus;

    /**
     * （整改反馈）已经整改项
     */
    private Long unCheckStatus;

    /**
     * 所有监管项
     */
    private List<SuperviseInfoSub> allSuperviseInfoSubs;

    /**
     * 需监管项
     */
    private List<SuperviseInfoSub> notSuperviseInfoSubs;

    /**
     * 已整改通过项
     */
    private List<SuperviseInfoSub> doneSuperviseInfoSubs;

    /**
     * 已整改未监管项
     */
    private List<SuperviseInfoSub> doneRectifyNotSuperviseInfoSub;

    /**
     * 未整改未监管项
     */
    private List<SuperviseInfoSub> notRectifyNotSuperviseInfoSub;


}
