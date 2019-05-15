package cn.shianxian.supervise.sys.dto;

import lombok.Data;

@Data
public class AuthorityDTO {

    /**
     * 名称
     */
    private String label;

    /**
     * 名称id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 子集
     */
    private AuthorityDTO children;
}
