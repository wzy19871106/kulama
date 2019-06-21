package cn.shianxian.supervise.sys.dto;

import cn.shianxian.supervise.record.pojo.Functionary;
import lombok.Data;

@Data
public class NodeFunctionaryDTO {


    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 标识。1：企业激活 2：负责人激活 3：未激活
     */
    private String flag;

    /**
     * 负责人
     */
    private Functionary functionary;
}
