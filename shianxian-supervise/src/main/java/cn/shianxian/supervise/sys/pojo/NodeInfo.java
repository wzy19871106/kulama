package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String nodeTag;

    /**
     * 节点名称
     */
    @Column(name = "nodeName")
    private String nodeName;

    /**
     * 节点法人身份证号或统一社会信用代码
     */
    @Column(name = "nodeNo")
    private String nodeNo;

    /**
     * 节点联系电话
     */
    @Column(name = "nodeTel")
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
     * 节点经济行业标识
     */
    @Column(name = "industryTag")
    private String industryTag;

    /**
     * 节点所属省
     */
    @Column(name = "nodeProvice")
    private String nodeProvice;

    /**
     * 节点所属市
     */
    @Column(name = "nodeCity")
    private String nodeCity;

    /**
     * 节点所属区
     */
    @Column(name = "nodeArea")
    private String nodeArea;

    /**
     * 节点所属乡镇
     */
    @Column(name = "nodeVillage")
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
    private String key;


    @Column(name = "keyUsed")
    private Integer keyUsed;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;


}
