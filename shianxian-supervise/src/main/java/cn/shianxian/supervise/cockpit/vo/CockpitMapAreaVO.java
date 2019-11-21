package cn.shianxian.supervise.cockpit.vo;

import lombok.Data;

@Data
public class CockpitMapAreaVO {

    /**
     * 区县名称
     */
    private String AreaName;

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
}
