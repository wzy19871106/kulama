package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@Table(name = "T_User")
public class User {


    /**
     * 用户标识
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "userTag")
    @Size(message = "用户标识过长！", max = 50)
    private String userTag;

    /**
     * 用户姓名
     */
    @NotEmpty(message = "用户姓名不能为空！")
    @Column(name = "userName")
    @Size(message = "用户姓名过长！", max = 200)
    private String userName;

    /**
     * 用户身份证号
     */
    @Column(name = "userNo")
    @Size(message = "用户身份证号过长！", max = 50)
    private String userNo;

    /**
     * 用户联系电话
     */
    @Column(name = "userTel")
    @Size(message = "用户联系电话过长！", max = 50)
    private String userTel;

    /**
     * 用户登录名
     */
    @NotEmpty(message = "登录名不能为空！")
    @Column(name = "userLoginName")
    @Size(message = "用户登录名过长！", max = 50)
    private String userLoginName;

    /**
     * 用户登录密码
     */
    @Column(name = "userLoginPass")
    @Size(message = "用户登录密码过长！", max = 50)
    private String userLoginPass;

    /**
     * 所属数据权限模板标识
     */
    @Column(name = "userGroupTag")
    @Size(message = "用户数据权限模板标识过长！", max = 50)
    private String userGroupTag;

    /**
     * 用户图片地址标识
     */
    @Column(name = "picTag")
    private String picTag;

    /**
     * 用户是否启用
     */
    @Column(name = "userDisabled")
    private Integer userDisabled;

    /**
     * 用户最后登陆时间
     */
    @Column(name = "userLastTime")
    private LocalDateTime userLastTime;

    /**
     * 用户错误次数
     */
    @Column(name = "userErrCount")
    private Long userErrCount;

    /**
     * 用户流水号
     */
    @Column(name = "`index`")
    private Long index;

    /**
     * 所属用户角色标识
     */
    @Column(name = "roleTag")
    @Size(message = "所属用户角色标识过长！", max = 50)
    private String roleTag;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

    /**
     * 所属数据权限模板标识
     */
    @Transient
    private String userGroupName;

    /**
     * token
     */
    @Transient
    private String token;

    /**
     * 所属用户角色名称
     */
    @Transient
    private String roleName;
}
