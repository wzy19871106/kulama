package cn.shianxian.supervise.test;

import cn.shianxian.supervise.common.pojo.Result;
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

}
