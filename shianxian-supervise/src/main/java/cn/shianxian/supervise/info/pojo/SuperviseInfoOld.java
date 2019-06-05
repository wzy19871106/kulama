package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 线下监管信息表
 */
@Data
@Table(name = "t_supervise_info_old")
public class SuperviseInfoOld implements Comparable<SuperviseInfoOld> {


    /**
     * 自增编码
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    /**
     * 企业编码
     */
    @Column(name = "nodeTag")
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    private String nodeName;

    /**
     * 企业地址
     */
    @Column(name = "nodeAddress")
    private String nodeAddress;

    /**
     * 线下监管类型编码
     */
    @Column(name = "superviseTypeTag")
    private String superviseTypeTag;

    /**
     * 不符合项序号
     */
    @Column(name = "unMatchId")
    private String unMatchId;

    /**
     * 不符合检查要点项
     */
    @Column(name = "unMatchPointId")
    private String unMatchPointId;

    /**
     * 问题数
     */
    @Column(name = "wrongNum")
    private String wrongNum;

    /**
     * 不符合内容
     */
    @Column(name = "unMatchContent")
    private String unMatchContent;

    /**
     * 整改措施
     */
    @Column(name = "requst")
    private String requst;

    /**
     * 回访落实情况（是：1否：0）
     */
    @Column(name = "returnVisitDone")
    private String returnVisitDone;

    /**
     * 逻辑删除
     */
    @Column(name = "ifDelete")
    private Integer ifDelete;

    /**
     * 监管时间
     */
    @Column(name = "superviseTime")
    private LocalDateTime superviseTime;


    @Override
    public int compareTo(SuperviseInfoOld o) {
        return this.unMatchContent.equals(o.getUnMatchContent()) ? 0 : 1;
    }

}
