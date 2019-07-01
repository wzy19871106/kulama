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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

class RecordingCleanTimer extends TimerTask {
    RecordingHandler handler;

    public RecordingCleanTimer(RecordingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        handler.clean();
    }
}

class UserInfo {
    long last_receive_time;
    FileOutputStream channel;
}

@Slf4j
public class RecordingHandler implements RecordingEventHandler {

    private RecordingConfig config = null;

    private RecordingSDK recording = null;

    private Timer cleanTimer = null;

    HashMap<String, UserInfo> audioChannels = new HashMap<>();
    HashMap<String, UserInfo> videoChannels = new HashMap<>();
    Vector<Long> peers = new Vector<>();

    public long nativeHandle;

    private Common.CHANNEL_PROFILE_TYPE profileType;

    public RecordingHandler(RecordingSDK recording) {
        this.recording = recording;
        recording.registerOberserver(this);
    }

    protected void clean() {
        synchronized (this) {
            long now = System.currentTimeMillis();

            Iterator<Map.Entry<String, UserInfo>> audio_it = audioChannels.entrySet().iterator();
            while (audio_it.hasNext()) {
                Map.Entry<String, UserInfo> entry = audio_it.next();
                UserInfo info = entry.getValue();
                if (now - info.last_receive_time > 3000) {
                    try {
                        info.channel.close();
                    } catch (IOException e) {
                        log.error("录制clean错误：{}，具体信息：{}", e, e.getMessage());
                    }
                    audio_it.remove();
                }
            }
            Iterator<Map.Entry<String, UserInfo>> video_it = videoChannels.entrySet().iterator();
            while (video_it.hasNext()) {
                Map.Entry<String, UserInfo> entry = video_it.next();
                UserInfo info = entry.getValue();
                if (now - info.last_receive_time > 3000) {
                    try {
                        info.channel.close();
                    } catch (IOException e) {
                        log.error("录制clean错误：{}，具体信息：{}", e, e.getMessage());
                    }
                    video_it.remove();
                }
            }
        }
        cleanTimer.schedule(new RecordingCleanTimer(this), 10000);
    }


//    private int SetVideoMixingLayout() {
//        Common ei = new Common();
//        Common.VideoMixingLayout layout = ei.new VideoMixingLayout();
//        int max_peers = profileType == Common.CHANNEL_PROFILE_TYPE.CHANNEL_PROFILE_COMMUNICATION ? 7 : 17;
//        if (peers.size() > max_peers) {
//            log.info("peers size is bigger than max m_peers:" + peers.size());
//            return -1;
//        }
//
//        if (!isMixMode())
//            return -1;
//
//        layout.canvasHeight = height;
//        layout.canvasWidth = width;
//        layout.backgroundColor = "#23b9dc";
//        layout.regionCount = (int) (m_peers.size());
//
//        if (!m_peers.isEmpty()) {
//            System.out.println("java setVideoMixingLayout m_peers is not empty, start layout");
//            Common.VideoMixingLayout.Region[] regionList = new Common.VideoMixingLayout.Region[m_peers.size()];
//            System.out.println("mixing layout mode:" + layoutMode);
//            if (layoutMode == BESTFIT_LAYOUT) {
//                adjustBestFitVideoLayout(regionList, layout);
//            } else if (layoutMode == VERTICALPRESENTATION_LAYOUT) {
//                adjustVerticalPresentationLayout(maxResolutionUid, regionList, layout);
//            } else {
//                adjustDefaultVideoLayout(regionList, layout);
//            }
//
//            layout.regions = regionList;
//
//        } else {
//            layout.regions = null;
//        }
//        return RecordingSDKInstance.setVideoMixingLayout(mNativeHandle, layout);
//    }

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
        cleanTimer = new Timer();
        cleanTimer.cancel();
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
        if (config.decodeAudio != Common.AUDIO_FORMAT_TYPE.AUDIO_FORMAT_DEFAULT_TYPE) {
            cleanTimer.schedule(new RecordingCleanTimer(this), 10000);
        }
        log.info("录制 App 加入频道，channelId：{}，uid：{}", channelId, uid);
    }

    @Override
    public void onUserOffline(long uid, int reason) {
        log.info("其他用户离开当前频道，uid：{}，reason：{}", uid, reason);
        peers.remove(uid);
//        PrintUsersInfo(m_peers);
//        SetVideoMixingLayout();
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
