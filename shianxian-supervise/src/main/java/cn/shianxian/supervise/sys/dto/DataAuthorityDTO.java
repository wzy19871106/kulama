package cn.shianxian.supervise.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DataAuthorityDTO {

    /**
     * id数组
     */
    @NotNull(message = "id数组不能为空！")
    private String[] ids;

    /**
     * 权限
     */
    @NotEmpty(message = "权限不能为空！")
    private String authority;

}
