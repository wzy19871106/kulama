package cn.shianxian.supervise.record.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 企业备案审核表
 */
@Table(name = "t_CompanyinfoForaduit")
@Data
public class CompanyInfoForaduit {

    /**
     * 企业标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "nodeTag")
    @NotEmpty(message = "企业标识不允许为空！")
    @Size(message = "企业标识过长！", max = 50)
    private String nodeTag;

    /**
     * 企业名称
     */
    @Column(name = "nodeName")
    @NotEmpty(message = "企业名称不允许为空！")
    @Size(message = "企业名称过长！", max = 200)
    private String nodeName;

    /**
     * 企业统一社会信用代码
     */
    @Column(name = "nodeNo")
    @Size(message = "企业统一社会信用代码过长！", max = 50)
    private String nodeNo;

    /**
     * 企业联系电话
     */
    @Column(name = "companyTel")
    @Size(message = "企业联系电话过长！", max = 50)
    private String companyTel;

    /**
     * 企业地址
     */
    @Column(name = "companyAddress")
    @Size(message = "企业地址过长！", max = 200)
    private String companyAddress;

    /**
     * 企业所属省
     */
    @Column(name = "companyProvice")
    @Size(message = "企业所属省过长！", max = 50)
    private String companyProvice;

    /**
     * 企业所属市
     */
    @Column(name = "companyCity")
    @Size(message = "企业所属市过长！", max = 50)
    private String companyCity;

    /**
     * 企业所属区
     */
    @Column(name = "companyArea")
    @Size(message = "企业所属区过长！", max = 50)
    private String companyArea;

    /**
     * 企业所属乡镇
     */
    @Column(name = "companyVillage")
    @Size(message = "企业所属乡镇过长！", max = 50)
    private String companyVillage;

    /**
     * 企业GIS经纬度
     */
    @Column(name = "companyGis")
    @Size(message = "企业GIS经纬度过长！", max = 50)
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
    @Size(message = "退回原因过长！", max = 200)
    private String failReason;

    /**
     *用户组的所拥有的数据权限
     */
    @Transient
    private String userDataUsedAuthoritySet;
}
