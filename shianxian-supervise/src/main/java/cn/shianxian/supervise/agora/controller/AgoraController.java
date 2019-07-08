package cn.shianxian.supervise.agora.controller;

import cn.shianxian.supervise.agora.hanlder.RecordingHandler;
import cn.shianxian.supervise.agora.pojo.AgoreConfig;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.thread.ThreadPool;
import io.agora.recording.RecordingSDK;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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


    /**
     * 开始录制
     * @param agoreConfig
     * @return
     * @throws Exception
     */
    @GetMapping("start")
    @ApiOperation(value = "开始录制", notes = "开始录制")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务id"),
            @ApiImplicitParam(paramType = "query", name = "channel", value = "频道号"),
            @ApiImplicitParam(paramType = "query", name = "androidUid", value = "安卓uid"),
            @ApiImplicitParam(paramType = "query", name = "pcUid", value = "pc端uid"),
    })
    public ResponseEntity<Result> start(@Valid AgoreConfig agoreConfig) throws Exception {
        log.info("开始录制视频：{}", agoreConfig);
        int activeCount = ThreadPool.getInstance().getActiveCount();
        log.info("线程池正在执行任务大概线程数：{}", activeCount);
        if (2 <= activeCount) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("服务器正忙，不可录制！ "));
        }
        agoreConfig.setAppId(appId);
        agoreConfig.setAppliteDir(appliteDir);
        agoreConfig.setRecordFileRootDir(recordFileRootDir + agoreConfig.getMainId());
        agoreConfig.setLowUdpPort(lowUdpPort);
        agoreConfig.setHighUdpPort(highUdpPort);
        File file = new File(agoreConfig.getRecordFileRootDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingHandler handler = new RecordingHandler(recordingSdk);
        Callable<Long> callable = () -> {
            long nativeHandle = handler.execute(agoreConfig);
            return nativeHandle;
        };
        FutureTask<Long> task = new FutureTask<>(callable);
        ThreadPool.getInstance().addExecuteTask(task);
        // 睡眠一秒，获取录制引擎
        Thread.sleep(1000);
        return ResponseEntity.ok(Result.data(handler.nativeHandle));
    }


    /**
     * 启动录制、暂停录制
     * @param nativeHandle
     * @return
     */
    @GetMapping("pause")
    @ApiOperation(value = "启动录制、暂停录制", notes = "启动录制、暂停录制")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nativeHandle", value = "录制引擎"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "[1:启动录制，2暂停录制]"),
    })

    public ResponseEntity<Result> pause(long nativeHandle, int type) {
        log.info("录制引擎：{}", nativeHandle);
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingHandler handler = new RecordingHandler(recordingSdk);
        if (1 == type) {
            handler.startService(nativeHandle);
        } else if (2 == type) {
            handler.stopService(nativeHandle);
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    /**
     * 停止录制
     * @param nativeHandle
     * @return
     */
    @GetMapping("stop")
    @ApiOperation(value = "停止录制", notes = "停止录制")
    @ApiImplicitParam(paramType = "query", name = "nativeHandle", value = "录制引擎")
    public ResponseEntity<Result> stop(long nativeHandle) {
        log.info("录制引擎：{}", nativeHandle);
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingHandler handler = new RecordingHandler(recordingSdk);
        handler.stopService(nativeHandle);
        handler.leaveChannel(nativeHandle);
        return ResponseEntity.ok(Result.successMsg());
    }


}