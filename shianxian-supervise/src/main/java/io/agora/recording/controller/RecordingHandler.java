package io.agora.recording.controller;

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


    public RecordingHandler(RecordingSDK recording) {
        this.recording = recording;
        recording.registerOberserver(this);
    }


    public void createChannel(Map<String, String> map) {
        String appId = map.get("appid");
        int uid = Integer.parseInt(map.get("uid"));
        String channel = map.get("channel");
        String appliteDir = map.get("appliteDir");
        String channelKey = map.get("channelKey");
        int channelProfile = Integer.parseInt(map.get("channelProfile"));
        boolean isAudioOnly = false;
        boolean isVideoOnly = false;
        boolean isMixingEnabled = false;
        String mixResolution = map.get("mixResolution");
        String mixedVideoAudio = map.get("mixedVideoAudio");
        String decryptionMode = map.get("decryptionMode");
        String secret = map.get("secret");
        String idle = map.get("idle");
        String recordFileRootDir = map.get("recordFileRootDir");
        int lowUdpPort = Integer.parseInt(map.get("lowUdpPort"));
        int highUdpPort = Integer.parseInt(map.get("highUdpPort"));
        String getAudioFrame = map.get("getAudioFrame");
        String getVideoFrame = map.get("getVideoFrame");
        String cfgFilePath = map.get("cfgFilePath");
        String streamType = map.get("streamType");
        String triggerMode = map.get("triggerMode");
        String proxyServer = map.get("proxyServer");
        int audioProfile = Integer.parseInt(map.get("audioProfile"));
        String defaultVideoBg = map.get("defaultVideoBg");
        String defaultUserBg = map.get("defaultUserBg");
        int logLevel = 5;
        String audioIndicationInterval = map.get("audioIndicationInterval");
        String layoutMode = map.get("layoutMode");
        String maxResolutionUid = map.get("maxResolutionUid");

        int idleLimitSec = 5 * 60;
        int captureInterval = 5;

        int width = 0;
        int height = 0;
        int fps = 0;
        int kbps = 0;

        if (appId == null || channel == null || appliteDir == null) {
            log.warn("缺少参数，无法录制");
            return;
        }
        if (audioProfile > 2) {
            audioProfile = 2;
        }
        if (audioProfile < 0) {
            audioProfile = 0;
        }

        RecordingConfig config = new RecordingConfig();
        config.channelProfile = Common.CHANNEL_PROFILE_TYPE.values()[channelProfile];
        config.idleLimitSec = idleLimitSec;
        config.isVideoOnly = isVideoOnly;
        config.isAudioOnly = isAudioOnly;
        config.isMixingEnabled = isMixingEnabled;
        config.mixResolution = mixResolution;
        config.mixedVideoAudio = Common.MIXED_AV_CODEC_TYPE.MIXED_AV_CODEC_V2;
        config.appliteDir = appliteDir;
        config.recordFileRootDir = recordFileRootDir;
        config.cfgFilePath = cfgFilePath;
        config.secret = secret;
        config.decryptionMode = decryptionMode;
        config.lowUdpPort = lowUdpPort;
        config.highUdpPort = highUdpPort;
        config.captureInterval = captureInterval;
        config.triggerMode = 1;
        config.proxyServer = proxyServer;
        config.audioProfile = audioProfile;
        this.config = config;

        log.info(System.getProperty("java.library.path"));

        // run jni event loop , or start a new thread to do it
        recording.createChannel(appId, channelKey, channel, uid, config, logLevel);
        log.info("开始录制...");
    }

    public boolean leaveChannel(long nativeHandle) {
        return recording.leaveChannel(nativeHandle);
    }

    public int startService(long nativeHandle) {
        return recording.startService(nativeHandle);
    }

    public int stopService(long nativeHandle) {
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
    }

    @Override
    public void onUserOffline(long uid, int reason) {
        log.info("其他用户离开当前频道，uid：{}，reason：{}", uid, reason);
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