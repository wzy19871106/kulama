package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * app获取版本号
 */

@RestController
@RequestMapping("version")
@Api(description = "app版本获取控制器")
@Slf4j
public class AppVersionController {

    @Autowired
    private AppVersionService appVersionService;

    // 10.18.9.57 /data/apps
    private static final String APP_FILE_PATH = "http://sapi.dev.shianxian.cn/apps/";
    private static final String APP_FILE_NAME = "app-debug.apk";
    private static final String APP_PAD_FILE_NAME = "http://sapi.dev.shianxian.cn/apps/app_pad/";
    private static final String APP_PAD_FILE_PATH = "app_pad_1.0.apk";

    /**
     * 根据id查询app版本号，返回文件下载路径
     *
     * @param
     * @return http://sapi.dev.shianxian.cn/apps/app-debug.apk
     */
    @GetMapping("selectAppVersionById")
    @ApiOperation(value = "查询app版本号,返回更新路径", notes = "查询app版本号，返回更新路径")
    public Result selectAppVersionById() {
        String version = this.appVersionService.selectAppVersion();
        Map<String, String> map = new HashMap();
        map.put("version", version);
        map.put("url", APP_FILE_PATH + APP_FILE_NAME);
        return Result.data(map);
    }

    /**
     * 查询AppPad版本号,返回更新路径
     *
     * @return  http://sapi.dev.shianxian.cn/apps/app_pad/app_pad_1.0.apk
     */
    @GetMapping("selectAppPadVersion")
    @ApiOperation(value = "查询AppPad版本号,返回更新路径", notes = "查询AppPad版本号,返回更新路径")
    public Result selectAppPadVersion() {
        String version = this.appVersionService.selectAppPadVersion();
        Map<String, String> map = new HashMap();
        map.put("version", version);
        map.put("url", APP_PAD_FILE_NAME + APP_PAD_FILE_PATH);
        return Result.data(map);
    }
}
