package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitAssessVO {

    /**
     * 商户、市场监管人员、网格员考核评议
     */
    private List<CockpitAssessNodeVO> cockpitAssessNodeVOList;

}
