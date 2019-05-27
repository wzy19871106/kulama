package cn.shianxian.supervise.sys.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
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
    private String userTag;

    /**
     * 用户姓名
     */
    @NotEmpty(message = "用户姓名不能为空！")
    @Column(name = "userName")
    private String userName;

    /**
     * 用户身份证号
     */
    @Column(name = "userNo")
    private String userNo;

    /**
     * 用户联系电话
     */
    @Column(name = "userTel")
    private String userTel;

    /**
     * 用户登录名
     */
    @NotEmpty(message = "登录名不能为空！")
    @Column(name = "userLoginName")
    private String userLoginName;

    /**
     * 用户登录密码
     */
    @NotEmpty(message = "密码不能为空！")
    @Column(name = "userLoginPass")
    @JsonIgnore
    private String userLoginPass;

    /**
     * 所属数据权限模板标识
     */
    @Column(name = "userGroupTag")
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
    private String roleTag;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;

}
