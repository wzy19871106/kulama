package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

import java.util.List;

@Data
public class CockpitMapCityVO {

    /**
     * 经营主体数量
     */
    private int companyNum;

    /**
     * 完成备案数量
     */
    private int backupCompanyNum;

    /**
     * 远程巡查次数
     */
    private int onlineCheckNum;

    /**
     * 线下巡查次数
     */
    private int offlineCheckNum;

    /**
     * 问题主体数量
     */
    private int failCompanyNum;

    /**
     * 发现问题数量
     */
    private int failNum;

    /**
     * 整改反馈数量
     */
    private int feedbackNum;

    /**
     * 整改回访数量
     */
    private int revisitNum;

    /**
     * 热点图街道对象
     */
    private List<CockpitMapAreaVO> cockpitMapAreaVOList;
}





