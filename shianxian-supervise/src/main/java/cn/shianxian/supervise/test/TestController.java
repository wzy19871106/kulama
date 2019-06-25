package cn.shianxian.supervise.test;

import cn.shianxian.supervise.common.pojo.Result;
import io.swagger.annotations.Api;
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
public class TestController {


    /**
     * 查询区域
     *
     * @return
     */
    @GetMapping("test")
    public ResponseEntity<Result> test() {
        RecordingSDK recordingSDK = new RecordingSDK();
        RecordingSampleM recordingSampleM = new RecordingSampleM(recordingSDK);
        String[] ars = new String[] {"--appId", "b676a4deb7964ee480fc51c72554c97e",
        "--uid", "123", "appliteDir", "/data/1", "", "--channel", "150055"
        };
        recordingSampleM.createChannel(ars);
        recordingSampleM.unRegister();
        long l = 0L;
        recordingSampleM.nativeObjectRef(l);
        recordingSampleM.leaveChannel(l);
        return ResponseEntity.ok(Result.successMsg());
    }


}
