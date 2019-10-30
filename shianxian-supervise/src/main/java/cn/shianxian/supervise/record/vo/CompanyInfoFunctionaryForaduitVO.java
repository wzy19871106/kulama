package cn.shianxian.supervise.record.vo;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * 企业备案审核表
 */
@Data
public class CompanyInfoFunctionaryForaduitVO {

    /**
     * 企业标识
     */
    private String companyNodeTag;

    /**
     * 企业名称
     */
    private String companyNodeName;

    /**
     * 企业统一社会信用代码
     */
    private String companyNodeNo;

    /**
     * 企业联系电话
     */
    private String companyTel;

    /**
     * 企业地址
     */
    private String companyAddress;

    /**
     * 企业所属省
     */
    private String companyProvice;

    /**
     * 企业所属市
     */
    private String companyCity;

    /**
     * 企业所属区
     */
    private String companyArea;

    /**
     * 企业所属乡镇
     */
    private String companyVillage;

    /**
     * 企业所属省
     */
    private String companyProviceName;

    /**
     * 企业所属市
     */
    private String companyCityName;

    /**
     * 企业所属区
     */
    private String companyAreaName;

    /**
     * 企业所属乡镇
     */
    private String companyVillageName;

    /**
     * 企业GIS经纬度
     */
    private String companyGis;

    /**
     * 企业图片地址标识
     */
    private String companyPicTag;

    /**
     * 1新增，2删除，3变更，4审核失败，5注销，0已完成
     */
    private String companyAduitType;

    /**
     * 退回原因
     */
    private String companyFailReason;

    /**
     * 企业流水号
     */
    private Long companyIndex;

    /**
     * 创建时间
     */
    private LocalDateTime companyCreateTime;

    /**
     * 负责人企业id
     */
    private String functionaryNodeTag;

    /**
     * 负责人企业名称
     */
    private String functionaryNodeName;

    /**
     * 负责人标识
     */
    private String functionaryTag;

    /**
     * 负责人名称
     */
    private String functionaryName;

    /**
     * 负责人身份证号
     */
    private String functionaryNo;

    /**
     * 负责人类型，1管理，2普通
     */
    private String functionaryType;

    /**
     * 负责人联系电话
     */
    private String functionaryTel;

    /**
     * 负责人图片地址标识
     */
    private String functionaryPicTag;

    /**
     * 节点流水号
     */
    private Long functionaryIndex;

    /**
     * 创建时间
     */
    private LocalDateTime functionaryCreateTime;

    /**
     * 审核状态:1新增，2删除，3变更，4审核失败，5注销，6注销通过，0已完成
     */
    private String functionaryAduitType;

    /**
     * 注销时间
     */
    private LocalDateTime functionaryUpdateTime;

    /**
     * 退回说明
     */
    private String functionaryFailReason;

    /**
     * 激活KEY
     */
    private String functionaryKey;

    /**
     * 负责人职位，无固定
     */
    private String functionaryPostition;

    /**
     * 类型
     */
    private String norfType;

}
