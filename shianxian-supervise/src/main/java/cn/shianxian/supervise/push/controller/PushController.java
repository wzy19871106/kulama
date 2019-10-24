package cn.shianxian.supervise.push.controller;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.JpushUtil;
import cn.shianxian.supervise.push.vo.JpushVO;
import com.submail.config.AppConfig;
import com.submail.lib.VoiceXSend;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    private static final String APP_ID = "21295";
    private static final String APP_KEY = "57e964bb738cdb99cb8d1d9fc229b8c2";
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
    @PostMapping("xsendConfig")
    @ApiOperation(value = "语音消息", notes = "语音消息")
    public Result xsendConfig(String userTal) {
//        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
        AppConfig appConfig = new AppConfig();
        appConfig.setAppId(APP_ID);
        appConfig.setAppKey(APP_KEY);
        VoiceXSend submail = new VoiceXSend(appConfig);
        submail.addTo(userTal);
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
}