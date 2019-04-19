package cn.shianxian.supervise.common.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pages {

    /**
     * 第几页
     */
    private Integer pageNum = 1;

    /**
     * 每页查询数量
     */
    private Integer pageSize = 10;
}
