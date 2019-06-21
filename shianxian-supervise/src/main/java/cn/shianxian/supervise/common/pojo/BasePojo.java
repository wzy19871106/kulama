package cn.shianxian.supervise.common.pojo;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BasePojo {


    /**
     * 创建日期
     */
    @Column(name = "`createTime`")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "`createUserTag`")
    private String createUserTag;

    /**
     * 最后更新日期
     */
    @Column(name = "`lastUpdateTime`")
    private LocalDateTime lastUpdateTime;

    /**
     * 最后更新人
     */
    @Column(name = "`lastUpdateUser`")
    private String lastUpdateUser;
}
