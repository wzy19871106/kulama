package io.agora.recording.controller;

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
    public ResponseEntity<Result> test(String name, String uid) {
        String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
                "--uid", uid, "--appliteDir", "/usr/local/cloud/supervise/agora/Agora_Recording_SDK_for_Linux_FULL/bin", "--channel", name
        };
        RecordingSDK RecordingSdk = new RecordingSDK();
        RecordingSample recordingSample = new RecordingSample(RecordingSdk);
        recordingSample.createChannel(args);
        recordingSample.unRegister();
        return ResponseEntity.ok(Result.data(recordingSample.getNativeHandle()));
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

