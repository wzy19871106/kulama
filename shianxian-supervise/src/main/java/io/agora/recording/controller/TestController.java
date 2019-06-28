package io.agora.recording.controller;

import cn.shianxian.supervise.common.pojo.Result;
import io.agora.recording.RecordingSDK;
import io.agora.recording.common.Common;
import io.agora.recording.common.RecordingConfig;
import io.agora.recording.handler.Handler;
import io.agora.recording.test.RecordingSampleM;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试控制器
 */
@RestController
@RequestMapping("test")
@Api(description = "测试控制器")
@Slf4j
public class TestController {



    @GetMapping("test")
    public ResponseEntity<Result> test() {
        RecordingSDK recordingSDK = new RecordingSDK();
        RecordingSampleM recordingSampleM = new RecordingSampleM(recordingSDK);
        String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
        "--uid", "55", "--appliteDir", "/data/1", "--channel", "150055"
        };
        recordingSampleM.createChannel(args);
        recordingSampleM.unRegister();

        return ResponseEntity.ok(Result.successMsg());
    }

    @GetMapping("test2")
    public ResponseEntity<Result> test2() {
        RecordingSDK recordingSDK = new RecordingSDK();
        RecordingSampleM recordingSampleM = new RecordingSampleM(recordingSDK);
        String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
                "--uid", "55", "--appliteDir", "/data/1", "--channel", "150055"
        };
        recordingSampleM.createChannel(args);
        long l = 0L;
        recordingSampleM.nativeObjectRef(l);
        log.info("录制引擎：{}", l);
        recordingSampleM.leaveChannel(l);
        return ResponseEntity.ok(Result.successMsg());
    }


    @GetMapping("test3")
    public ResponseEntity<Result> test3(String name, int uid) {

        RecordingConfig config = new RecordingConfig();
        // 设置是否启用合流模式
        config.isMixingEnabled = true;
        // 合流模式下将一个音频录制文件和一个视频录制文件实时混合成一个既有音频也有视频的 MP4 文件
        config.mixedVideoAudio = Common.MIXED_AV_CODEC_TYPE.MIXED_AV_CODEC_V2;
        // 设置为 AgoraCoreServices 存放的目录
        config.appliteDir = "/usr/local/cloud/supervise/agora/appliteDir";
        // 设置录制文件存放的根目录
        config.recordFileRootDir = "/usr/local/cloud/supervise/";
        // Recording_Dir 参数设置存放录制文件的绝对路径
//        config.cfgFilePath = "{'Recording_Dir' : '/usr/local/cloud/supervise/agora/so'}";
        // 设置视频解码格式
        config.decodeVideo = Common.VIDEO_FORMAT_TYPE.VIDEO_FORMAT_JPG_VIDEO_FILE_TYPE;
        // 设置音频解码格式
        config.decodeAudio = Common.AUDIO_FORMAT_TYPE.AUDIO_FORMAT_DEFAULT_TYPE;
        // 设置最低 UDP 端口
        config.lowUdpPort = 20000;
        // 设置最高 UDP 端口
        config.highUdpPort = 50000;
        // 选择录制启动模式
        config.triggerMode = 1;
//        config.proxyServer = 1;

        RecordingSDK recordingSDK = new RecordingSDK();
        String appId = "b676a4deb7964ee480fc51c72554c97e";
        String channelKey = "";
//        String name = "150055";//频道号
//        int uid = 55;
        int logLevel = 5;
        recordingSDK.createChannel(appId, channelKey, name, uid, config, logLevel);
        Handler handler = new Handler();
        Common c = new Common();
        Common.VideoMixingLayout layout = c.new VideoMixingLayout();
        layout.canvasHeight = 100;
        layout.canvasWidth = 100;
        recordingSDK.setVideoMixingLayout(handler.nativeHandle, layout);
        recordingSDK.startService(handler.nativeHandle);
        return ResponseEntity.ok(Result.data(handler.nativeHandle));
    }


    @GetMapping("test4")
    public ResponseEntity<Result> test4(long nativeHandle) {
        RecordingSDK recordingSDK = new RecordingSDK();
        recordingSDK.startService(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }
}

