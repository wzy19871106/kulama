package cn.shianxian.supervise.push.controller;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.JpushUtil;
import cn.shianxian.supervise.push.vo.JpushVO;
import com.submail.config.AppConfig;
import com.submail.lib.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 推送控制器
 */
@RestController
@RequestMapping("push")
@Api(description = "推送控制器")
@Slf4j
public class PushController {

    private static final String VOICE_APP_ID = "21295";
    private static final String VOICE_APP_KEY = "57e964bb738cdb99cb8d1d9fc229b8c2";

    private static final String MESSAGE_APP_ID = "42304";
    private static final String MESSAGE_APP_KEY = "d9e0564ef4cf8462c9ac702101e02f6f";

    /**
     * 极光推送
     */
    @PostMapping("SendPushWith")
    @ApiOperation(value = "推送", notes = "推送")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "msg", value = "自定义推送内容"),
            @ApiImplicitParam(paramType = "query", name = "title", value = "推送主题"),
            @ApiImplicitParam(paramType = "query", name = "alias", value = "别名"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "registrationId指定用户")
    })
    public ResponseEntity<Result> JpushAndroid(JpushVO jpushVO) {
        Map<String, String> parm = new HashMap<>();
        parm.put("msg", jpushVO.getMsg());
        parm.put("title", jpushVO.getTitle());
        parm.put("alias", jpushVO.getAlias());
        parm.put("id", jpushVO.getId());
        Result result = JpushUtil.jpushAndroid(parm);
        log.info("极光推送，{}", result);
        return ResponseEntity.ok(result);
    }

    /**
     * 语音消息
     *
     * @return
     */
    @GetMapping("xsendConfig")
    @ApiOperation(value = "语音消息", notes = "语音消息")
    @ApiImplicitParam(paramType = "query", name = "userTel", value = "手机号")
    public Result xsendConfig(String userTel) {
//        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
        AppConfig appConfig = new AppConfig();
        appConfig.setAppId(VOICE_APP_ID);
        appConfig.setAppKey(VOICE_APP_KEY);
        VoiceXSend submail = new VoiceXSend(appConfig);
        submail.addTo(userTel);
        submail.addProject("XebWP");
//        submail.addVars("name","张三");
//        submail.addVars("code","2244");
        String xsend = null;
        try {
            xsend = submail.xsend();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("语音：{}", xsend);
        return Result.data(xsend);
    }


    /**
     * 短信通知
     *
     * @param userTel
     * @return
     */
    @GetMapping("messageSend")
    @ApiOperation(value = "短息通知", notes = "短息通知")
    @ApiImplicitParam(paramType = "query", name = "userTel", value = "手机号")
    public Result messageSend(String userTel) {
        AppConfig appConfig = new AppConfig();
        appConfig.setAppId(MESSAGE_APP_ID);
        appConfig.setAppKey(MESSAGE_APP_KEY);
        MESSAGEXsend submail = new MESSAGEXsend(appConfig);
        submail.addTo(userTel);
        submail.setProject("uhskD");
        submail.addVar("NodeName","被监管用户");
        submail.addVar("Address","http://27.115.49.59:90/JxcAppWeb/AppOpen.html");
        String xsend = "";
        try {
            xsend = submail.xsend();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("通知短信：{}", xsend);
        return Result.data(xsend);
    }
}