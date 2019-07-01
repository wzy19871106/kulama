package io.agora.recording.controller;

import cn.shianxian.supervise.common.pojo.Result;
import io.agora.recording.RecordingSDK;
import io.agora.recording.test.RecordingSample;
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
    public ResponseEntity<Result> test(String name, String uid) throws Exception {
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingSample[] recordingSample = {new RecordingSample(recordingSdk)};
        Executors.execute(new Runnable() {
            @Override
            public void run() {
                String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
                        "--uid", uid,
                        "--appliteDir", "/usr/local/cloud/supervise/agora/Agora_Recording_SDK_for_Linux_FULL/bin",
                        "--channel", name,
                        "--lowUdpPort", "10000",
                        "--highUdpPort", "50000",
                        "--triggerMode", "1",
                };
                recordingSample[0].createChannel(args);
                recordingSample[0].unRegister();
            }
        });
        return ResponseEntity.ok(Result.data(this.getNativeHandle(name)));
    }


    public Long getNativeHandle(String name) {
        if (Executors.nativeHandleMap.containsKey(name)) {
            Long nativeHandle = Executors.nativeHandleMap.get(name);
            log.info("录制引擎：{}", nativeHandle);
            Executors.nativeHandleMap.remove(name);
            return nativeHandle;
        } else {
            log.info("递归获取引擎.....");
            return getNativeHandle(name);
        }
    }


    @GetMapping("test2")
    public ResponseEntity<Result> test2(long nativeHandle) {
        RecordingSDK RecordingSdk = new RecordingSDK();
        RecordingSample recordingSample = new RecordingSample(RecordingSdk);
        log.info("录制引擎：{}", nativeHandle);
        recordingSample.leaveChannel(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }


    @GetMapping("test3")
    public ResponseEntity<Result> test3(String name, String uid) throws Exception {
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingSampleM recordingSample = new RecordingSampleM(recordingSdk);
        String[] args = {"--appId", "b676a4deb7964ee480fc51c72554c97e",
                "--uid", uid,
                "--appliteDir", "/usr/local/cloud/supervise/agora/Agora_Recording_SDK_for_Linux_FULL/bin",
                "--channel", name,
                "--lowUdpPort", "10000",
                "--highUdpPort", "50000",
                "--triggerMode", "1",
        };
        recordingSample.createChannel(args);
        recordingSample.startService(recordingSample.mNativeHandle);
        recordingSample.unRegister();
        return ResponseEntity.ok(Result.data(recordingSample.mNativeHandle));
    }


    @GetMapping("test4")
    public ResponseEntity<Result> test4(long nativeHandle) {
        RecordingSDK RecordingSdk = new RecordingSDK();
        RecordingSampleM recordingSample = new RecordingSampleM(RecordingSdk);
        log.info("录制引擎：{}", nativeHandle);
        recordingSample.stopService(nativeHandle);
        recordingSample.leaveChannel(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }
}