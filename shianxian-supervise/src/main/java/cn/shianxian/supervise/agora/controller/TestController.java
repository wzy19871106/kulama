package cn.shianxian.supervise.agora.controller;

import cn.shianxian.supervise.common.pojo.Result;
import io.agora.recording.RecordingSDK;
import io.agora.recording.test.RecordingSample;
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
    public ResponseEntity<Result> test(String name, String uid) throws Exception {
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingSample recordingSample = new RecordingSample(recordingSdk);
        String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
                "--uid", uid,
                "--appliteDir", "/usr/local/cloud/supervise/agora/Agora_Recording_SDK_for_Linux_FULL/bin",
                "--channel", name,
                "--lowUdpPort", "10000",
                "--highUdpPort", "50000",
                "--triggerMode", "1"
        };
        recordingSample.createChannel(args);
        log.info("mNativeHandle============:{}", recordingSample.mNativeHandle);
        recordingSample.startService(recordingSample.mNativeHandle);
        recordingSample.unRegister();
        return ResponseEntity.ok(Result.data(recordingSample.mNativeHandle));
    }



    @GetMapping("test2")
    public ResponseEntity<Result> test2(long nativeHandle) {
        RecordingSDK RecordingSdk = new RecordingSDK();
        RecordingSample recordingSample = new RecordingSample(RecordingSdk);
        log.info("录制引擎：{}", nativeHandle);
        recordingSample.leaveChannel(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }



}