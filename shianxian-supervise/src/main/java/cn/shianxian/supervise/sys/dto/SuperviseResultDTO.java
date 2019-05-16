package cn.shianxian.supervise.sys.dto;

import lombok.Data;

@Data
public class SuperviseResultDTO {


    /**
     * 监管类型id
     */
    private String superviseTypeTag;

    /**
     * 监管类型名称
     */
    private String superviseTypeName;

    /**
     * 监管内容父id
     */
    private String parentTag;

    /**
     * 监管内容父名称
     */
    private String parentSuperviseName;

    /**
     * 监管内容id
     */
    private String superviseTag;

    /**
     * 监管内容名称
     */
    private String superviseName;

    /**
     * 监管结果id
     */
    private String resultTag;

    /**
     * 监管结果
     */
    private String resultValue;

    /**
     * 分数
     */
    private String score;

    /**
     * 备注
     */
    private String remark;
}