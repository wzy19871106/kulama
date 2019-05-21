package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 企业备案表
 */
@Table(name = "CompanyinfoForaduit")
@Data
public class CompanyInfoForaduit {

    /**
     * 企业标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "nodeTag")
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    private String nodeName;

    /**
     * 企业统一社会信用代码
     */
    @Column(name = "nodeNo")
    private String nodeNo;

    /**
     * 企业联系电话
     */
    @Column(name = "companyTel")
    private String companyTel;

    /**
     * 企业地址
     */
    @Column(name = "companyAddress")
    private String companyAddress;

    /**
     * 企业所属省
     */
    @Column(name = "companyProvice")
    private String companyProvice;

    /**
     * 企业所属市
     */
    @Column(name = "companyCity")
    private String companyCity;

    /**
     * 企业所属区
     */
    @Column(name = "companyArea")
    private String companyArea;

    /**
     * 企业所属乡镇
     */
    @Column(name = "companyVillage")
    private String companyVillage;

    /**
     * 企业GIS经纬度
     */
    @Column(name = "companyGis")
    private String companyGis;

    /**
     * 企业图片地址标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 企业流水号
     */
    @Column(name = "`index`")
    private Long index;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 1新增，2删除，3变更，4审核失败，5注销，0已完成
     */
    @Column(name = "aduitType")
    private String aduitType;

    /**
     * 退回原因
     */
    @Column(name = "failReason")
    private String failReason;

}
