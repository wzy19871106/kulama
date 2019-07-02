package cn.shianxian.supervise.agora.controller;

import io.agora.recording.RecordingEventHandler;
import io.agora.recording.RecordingSDK;
import io.agora.recording.common.Common;
import io.agora.recording.common.Common.AudioFrame;
import io.agora.recording.common.Common.AudioVolumeInfo;
import io.agora.recording.common.Common.VideoFrame;
import io.agora.recording.common.RecordingConfig;
import io.agora.recording.common.RecordingEngineProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class RecordingHandler implements RecordingEventHandler {

    private RecordingConfig config = null;

    private RecordingSDK recording = null;

    public long nativeHandle;

    public String channel;


    public RecordingHandler(RecordingSDK recording) {
        this.recording = recording;
        recording.registerOberserver(this);
    }


    public long execute(Map<String, String> map) {
        String appId = map.get("appId");
        int uid = 0;
        channel = map.get("channel");
        String appliteDir = map.get("appliteDir");
        String recordFileRootDir = map.get("recordFileRootDir");
        int lowUdpPort = Integer.parseInt(map.get("lowUdpPort"));
        int highUdpPort = Integer.parseInt(map.get("highUdpPort"));
        int logLevel = 5;

        if (appId == null || channel == null || appliteDir == null) {
            log.warn("缺少参数，无法录制");
            return nativeHandle;
        }
        RecordingConfig config = new RecordingConfig();
        // 设置是否启用合流模式
        config.isMixingEnabled = true;
        // 设置为 AgoraCoreServices 存放的目录
        config.appliteDir = appliteDir;
        config.recordFileRootDir = recordFileRootDir;
        // 设置视频解码格式
        config.decodeVideo = Common.VIDEO_FORMAT_TYPE.VIDEO_FORMAT_DEFAULT_TYPE;
        // 设置音频解码格式
        config.decodeAudio = Common.AUDIO_FORMAT_TYPE.AUDIO_FORMAT_DEFAULT_TYPE;
        // 设置最低 UDP 端口
        config.lowUdpPort = lowUdpPort;
        // 设置最高 UDP 端口
        config.highUdpPort = highUdpPort;
        // 直播模式
        config.channelProfile = Common.CHANNEL_PROFILE_TYPE.CHANNEL_PROFILE_LIVE_BROADCASTING;
        config.mixedVideoAudio = Common.MIXED_AV_CODEC_TYPE.MIXED_AV_CODEC_V2;
        config.mixResolution = "960,720,15,1820";

        this.config = config;
        log.info(System.getProperty("java.library.path"));
        boolean falg = recording.createChannel(appId, "", channel, uid, config, logLevel);
        log.info("创建并让录制 App 加入频道，是否成功：{}", falg);
        log.info("录制引擎：{}", nativeHandle);
        log.info("开始录制...");
        return nativeHandle;
    }

    private int setVideoMixingLayout() {
        Common ei = new Common();
        Common.VideoMixingLayout layout = ei.new VideoMixingLayout();
        layout.canvasHeight = 700;
        layout.canvasWidth = 950;
        layout.backgroundColor = "#000000";
        layout.regionCount = 2;
        Common.VideoMixingLayout.Region[] regions = new Common.VideoMixingLayout.Region[2];
        Common.VideoMixingLayout.Region region1 = layout.new Region();
        region1.x = 0;
        region1.y = 0;
        region1.width = 0;
        region1.height = 0;
        region1.alpha = 1;
        region1.renderMode = 2;
        Common.VideoMixingLayout.Region region2 = layout.new Region();
        region2.uid = 123;
        region2.x = 0;
        region2.y = 0;
        region2.width = 0;
        region2.height = 0;
        region2.alpha = 0;
        region2.renderMode = 2;
        regions[0] = region1;
        regions[1] = region2;
        layout.regions = regions;
        log.info("画布布局...");
        return recording.setVideoMixingLayout(nativeHandle, layout);
    }


    public boolean leaveChannel(long nativeHandle) {
        return recording.leaveChannel(nativeHandle);
    }

    public int startService(long nativeHandle) {
        log.info("开始录制，录制引擎：{}", nativeHandle);
        return recording.startService(nativeHandle);
    }

    public int stopService(long nativeHandle) {
        log.info("结束录制：{}", nativeHandle);
        return recording.stopService(nativeHandle);
    }

    public RecordingEngineProperties getProperties(long nativeHandle) {
        return recording.getProperties(nativeHandle);
    }

    public void unRegister() {
        recording.unRegisterOberserver(this);
    }


    public void nativeObjectRef(long nativeHandle) {
        this.nativeHandle = nativeHandle;
        log.info("开始获取录制引擎，nativeHandle：{}", nativeHandle);
    }

    @Override
    public void onLeaveChannel(int reason) {
        log.info("录制 App 离开频道，reason：{}", reason);
    }

    @Override
    public void onError(int error, int stat_code) {
        log.info("发生错误，error：{}，stat_code：{}", error, stat_code);
    }

    @Override
    public void onWarning(int warn) {
        log.info("发生警告，warn：{}", warn);
    }

    @Override
    public void onJoinChannelSuccess(String channelId, long uid) {
        log.info("录制 App 加入频道，channelId：{}，uid：{}", channelId, uid);
        this.setVideoMixingLayout();
    }

    @Override
    public void onUserOffline(long uid, int reason) {
        log.info("其他用户离开当前频道，uid：{}，reason：{}", uid, reason);
        this.setVideoMixingLayout();
    }

    @Override
    public void onUserJoined(long uid, String recordingDir) {
        log.info("其他用户加入当前频道，uid：{}，recordingDir：{}", uid, recordingDir);
    }

    @Override
    public void onActiveSpeaker(long uid) {
        log.info("监测到活跃用户频道，uid：{}", uid);
    }

    @Override
    public void audioFrameReceived(long uid, AudioFrame frame) {
        log.info("收到原始音频数据，uid：{}，AudioFrame：{}", uid, frame);
    }

    @Override
    public void videoFrameReceived(long uid, int type, VideoFrame frame, int rotation) {
        log.info("收到原始视频数据，uid：{}，type：{}，VideoFrame：{}，rotation：{}", uid, type, frame, rotation);
    }

    @Override
    public void stopCallBack() {
        log.info("停止接收");
    }

    @Override
    public void recordingPathCallBack(String path) {
        log.info("获取录制文件所在目录，path：{}", path);
    }

    @Override
    public void onAudioVolumeIndication(AudioVolumeInfo[] infos) {
        log.info("提示频道内谁正在说话及说话者音量，infos：{}", infos);
    }

    @Override
    public void onFirstRemoteVideoDecoded(long uid, int width, int height, int elapsed) {
        log.info("已完成远端视频首帧解码，uid：{}，width：{}，height：{}，elapsed：{}", uid, width, height, elapsed);
    }

    @Override
    public void onFirstRemoteAudioFrame(long uid, int elapsed) {
        log.info("已接收远端音频首帧，uid：{}，elapsed：{}", uid, elapsed);
    }

    @Override
    public void onReceivingStreamStatusChanged(boolean receivingAudio, boolean receivingVideo) {
        log.info("流状态变化，receivingAudio：{}，receivingVideo：{}", receivingAudio, receivingVideo);
    }

    @Override
    public void onConnectionLost() {
        log.info("网络连接丢失");
    }

    @Override
    public void onConnectionInterrupted() {
        log.info("网络连接中断");
    }


}
