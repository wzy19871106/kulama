package cn.shianxian.supervise.info.vo;

import lombok.Data;

import java.util.List;

/**
 * 监管结果VO（树）
 */
@Data
public class SuperviseInfoTreeVO {


    /**
     * 监管内容
     */
    private List<SuperviseVO> supervise;

    /**
     * 监管分数
     */
    private SuperviseInfoScoreVO score;

}
