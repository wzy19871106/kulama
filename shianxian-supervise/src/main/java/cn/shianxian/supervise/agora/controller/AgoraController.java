package cn.shianxian.supervise.agora.controller;

import cn.shianxian.supervise.agora.controller.hanlder.RecordingHandler;
import cn.shianxian.supervise.agora.controller.pojo.AgoreConfig;
import cn.shianxian.supervise.common.pojo.Result;
import io.agora.recording.RecordingSDK;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * 声网控制器
 */
@RestController
@RequestMapping("agora")
@Api(description = "声网控制器")
@Slf4j
public class AgoraController {


    @Value("${agora.appId}")
    private String appId;

    @Value("${agora.appliteDir}")
    private String appliteDir;

    @Value("${agora.recordFileRootDir}")
    private String recordFileRootDir;

    @Value("${agora.lowUdpPort}")
    private int lowUdpPort;

    @Value("${agora.highUdpPort}")
    private int highUdpPort;

    @GetMapping("start")
    @ApiOperation(value = "开始录制", notes = "开始录制")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务id"),
            @ApiImplicitParam(paramType = "query", name = "channel", value = "频道号"),
            @ApiImplicitParam(paramType = "query", name = "androidUid", value = "安卓uid"),
            @ApiImplicitParam(paramType = "query", name = "pcUid", value = "pc端uid"),
    })
    public ResponseEntity<Result> start(@Valid AgoreConfig agoreConfig) throws Exception {
        agoreConfig.setAppId(appId);
        agoreConfig.setAppliteDir(appliteDir);
        agoreConfig.setRecordFileRootDir(recordFileRootDir);
        agoreConfig.setLowUdpPort(lowUdpPort);
        agoreConfig.setHighUdpPort(highUdpPort);
        File file = new File(recordFileRootDir + agoreConfig.getMainId());
        if (!file.exists()) {
            file.mkdirs();
        }
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingHandler handler = new RecordingHandler(recordingSdk);
        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() {
                long nativeHandle = handler.execute(agoreConfig);
                return nativeHandle;
            }
        };
        FutureTask<Long> task = new FutureTask<>(callable);
        task.run();
        return ResponseEntity.ok(Result.data(task.get()));
    }


    @GetMapping("stop")
    @ApiOperation(value = "停止录制", notes = "停止录制")
    @ApiImplicitParam(paramType = "query", name = "nativeHandle", value = "录制引擎")
    public ResponseEntity<Result> stop(long nativeHandle) {
        log.info("录制引擎：{}", nativeHandle);
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingHandler handler = new RecordingHandler(recordingSdk);
        handler.leaveChannel(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }


}