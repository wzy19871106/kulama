package cn.shianxian.supervise.agora.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AgoreConfig {


    /**
     * appId
     */
    private String appId;

    /**
     * 频道号
     */
    @NotEmpty(message = "频道号不能为空！")
    private String channel;

    /**
     * AgoraCoreServices 存放的目录
     */
    private String appliteDir;

    /**
     * 录制视频存放目录
     */
    private String recordFileRootDir;

    /**
     * 最低端口
     */
    private int lowUdpPort;

    /**
     * 最高端口
     */
    private int highUdpPort;

    /**
     * 安卓uid
     */
    @NotNull(message = "安卓uid不能为空！")
    private int androidUid;

    /**
     * pc端uid
     */
    @NotNull(message = "pc端uid不能为空！")
    private int pcUid;

    /**
     * 监管业务id
     */
    @NotEmpty(message = "监管业务id不能为空！")
    private String mainId;

}
