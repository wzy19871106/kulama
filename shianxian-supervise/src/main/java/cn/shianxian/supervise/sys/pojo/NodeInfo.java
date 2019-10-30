package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * 节点
 */
@Data
@Table(name = "t_nodeinfo")
public class NodeInfo {


    /**
     * 节点标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "nodeTag")
    @Size(message = "节点标识过长！", max = 50)
    private String nodeTag;

    /**
     * 节点名称
     */
    @Column(name = "nodeName")
    @Size(message = "节点名称过长！", max = 200)
    private String nodeName;

    /**
     * 节点法人身份证号或统一社会信用代码
     */
    @Column(name = "nodeNo")
    @Size(message = "节点法人身份证号或统一社会信用代码过长！", max = 50)
    private String nodeNo;

    /**
     * 节点联系电话
     */
    @Column(name = "nodeTel")
    @Size(message = "节点联系电话过长！", max = 50)
    private String nodeTel;

    /**
     * 节点图片地址标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 用户组的所拥有的数据权限
     */
    @Column(name = "userDataUsedAuthoritySet")
    private String userDataUsedAuthoritySet;

    /**
     * 节点流水号
     */
    @Column(name = "`index`")
    private Long index;

    /**
     * 办事处
     */
    @Column(name = "bak1")
    private String office;

    /**
     * 节点经济行业标识
     */
    @Column(name = "industryTag")
    @Size(message = "节点经济行业标识过长！", max = 50)
    private String industryTag;

    /**
     * 节点所属省
     */
    @Column(name = "nodeProvice")
    @Size(message = "节点所属省过长！", max = 50)
    private String nodeProvice;

    /**
     * 节点所属市
     */
    @Column(name = "nodeCity")
    @Size(message = "节点所属市过长！", max = 50)
    private String nodeCity;

    /**
     * 节点所属区
     */
    @Column(name = "nodeArea")
    @Size(message = "节点所属区过长！", max = 50)
    private String nodeArea;

    /**
     * 节点所属乡镇
     */
    @Column(name = "nodeVillage")
    @Size(message = "节点所属乡镇过长！", max = 50)
    private String nodeVillage;

    /**
     * 节点是否启用
     */
    @Column(name = "nodeDisabled")
    private String nodeDisabled;

    /**
     * 节点激活KEY
     */
    @Column(name = "`key`")
    @Size(message = "节点激活KEY过长！", max = 50)
    private String key;


    @Column(name = "keyUsed")
    private Integer keyUsed;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;


    /**
     * 节点所属省
     */
    @Transient
    private String nodeProviceName;

    /**
     * 节点所属市
     */
    @Transient
    private String nodeCityName;

    /**
     * 节点所属区
     */
    @Transient
    private String nodeAreaName;

    /**
     * 节点所属乡镇
     */
    @Transient
    private String nodeVillageName;

    /**
     * 节点经济行业标识
     */
    @Transient
    private String industryName;

    /**
     * 所属片区
     */
    @Transient
    private String authority;
}
