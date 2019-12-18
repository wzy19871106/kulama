package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitAssessCompositeSuperviseTypeAreaBar {

    /**
     * 商户、监管人员、网格员名称
     */
    private String nodeName;

    /**
     * 得分
     */
    private String assessScore;
}
