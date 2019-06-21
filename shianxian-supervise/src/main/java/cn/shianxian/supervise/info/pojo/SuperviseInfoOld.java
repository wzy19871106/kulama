package cn.shianxian.supervise.info.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
    @Size(message = "企业编码过长！", max = 50)
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    @Size(message = "企业名称过长！", max = 100)
    private String nodeName;

    /**
     * 企业地址
     */
    @Column(name = "nodeAddress")
    @Size(message = "企业地址过长！", max = 200)
    private String nodeAddress;

    /**
     * 线下监管类型编码
     */
    @Column(name = "superviseTypeTag")
    @Size(message = "线下监管类型编码过长！", max = 50)
    private String superviseTypeTag;

    /**
     * 不符合项序号
     */
    @Column(name = "unMatchId")
    @Size(message = "不符合项序号过长！", max = 50)
    private String unMatchId;

    /**
     * 不符合检查要点项
     */
    @Column(name = "unMatchPointId")
    @Size(message = "不符合检查要点项过长！", max = 50)
    private String unMatchPointId;

    /**
     * 问题数
     */
    @Column(name = "wrongNum")
    @Size(message = "问题数过长！", max = 10)
    private String wrongNum;

    /**
     * 不符合内容
     */
    @Column(name = "unMatchContent")
    @Size(message = "不符合内容过长！", max = 1000)
    private String unMatchContent;

    /**
     * 整改措施
     */
    @Column(name = "requst")
    @Size(message = "整改措施过长！", max = 1000)
    private String requst;

    /**
     * 回访落实情况（是：1否：0）
     */
    @Column(name = "returnVisitDone")
    @Size(message = "回访落实情况过长！", max = 10)
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
