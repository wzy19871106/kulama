package cn.shianxian.supervise.government.vo;

import lombok.Data;

@Data
public class Analysis {


    /**
     * 备案完整率
     */
    private Double backUpCompleteRate;

    /**
     * 规范经营率
     */
    private Double standardOperatingRate;

    /**
     * 问题复现率
     */
    private Double problemRecurrenceRate;

    /**
     * 整改完成率
     */
    private Double rectificationCompletionRate;

    /**
     * 及时整改率
     */
    private Double timelycorrectionRate;

}
