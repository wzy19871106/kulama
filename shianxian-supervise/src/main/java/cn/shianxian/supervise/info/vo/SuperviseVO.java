package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.util.List;

/**
 * 监管内容结果（树）
 */
@Data
public class SuperviseVO {


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
     * 得分数
     */
    private String score;

    /**
     * 总分数
     */
    private String scoreValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子集
     */
    List<SuperviseVO> infoTreeList;

}
