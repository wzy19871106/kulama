package io.agora.recording.handler;

import io.agora.recording.RecordingEventHandler;
import io.agora.recording.common.Common;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler implements RecordingEventHandler {


    public volatile long nativeHandle;



    @Override
    public void nativeObjectRef(long nativeHandle) {
        this.nativeHandle = nativeHandle;
        log.info("获取录制引擎：{}", nativeHandle);
    }

    @Override
    public void onLeaveChannel(int reason) {
        log.info("录制 App 离开频道：{}", reason);
    }

    @Override
    public void onError(int error, int stat_code) {
        log.error("录制发生错误：{}，状态码：{}", error, stat_code);
    }

    @Override
    public void onWarning(int warn) {
        log.error("录制发生警告，状态码：{}", warn);
    }

    @Override
    public void onJoinChannelSuccess(String channelId, long uid) {
        log.info("录制 App 加入频道，channelId：{}，iud：{}", channelId, uid);
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
        log.info("监测到活跃用户，uid：{}", uid);
    }

    @Override
    public void audioFrameReceived(long uid, Common.AudioFrame frame) {
        log.info("收到原始音频数据，uid：{}，frame：{}", uid, frame);
    }

    @Override
    public void videoFrameReceived(long uid, int type, Common.VideoFrame frame, int rotation) {
        log.info("收到原始视频数据，uid：{}，type：{}，uid：{}，rotation：{}", uid, type, frame, rotation);
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
    public void onAudioVolumeIndication(Common.AudioVolumeInfo[] infos) {
        log.info("提示频道内谁正在说话及说话者音量，infos：{}", infos);
    }

    @Override
    public void onFirstRemoteVideoDecoded(long uid, int width, int height, int elapsed) {
        log.info("已完成远端视频首帧解码，uid：{}，width：{}，height：{}，elapsed：{}", uid, elapsed, height, elapsed);
    }

    @Override
    public void onFirstRemoteAudioFrame(long uid, int elapsed) {
        log.info("已接收远端音频首帧，uid：{}，elapsed：{}", uid, elapsed);

    }

    @Override
    public void onReceivingStreamStatusChanged(boolean receivingAudio, boolean receivingVideo) {
        log.info("流状态变化，声音：{}，视频：{}", receivingAudio, receivingVideo);
    }

    @Override
    public void onConnectionLost() {
        log.error("网络连接丢失");
    }

    @Override
    public void onConnectionInterrupted() {
        log.error("网络连接中断");
    }
}
