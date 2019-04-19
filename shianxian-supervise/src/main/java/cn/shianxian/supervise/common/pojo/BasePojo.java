package cn.shianxian.supervise.common.pojo;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BasePojo {

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private LocalDateTime createTime;
}
