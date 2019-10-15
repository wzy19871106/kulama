package cn.shianxian.supervise.push.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.JpushUtil;
import cn.shianxian.supervise.push.vo.JpushVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Result> JpushAndroid(JpushVO jpushVO){
        Map<String, String> parm = new HashMap<>();
        parm.put("msg",jpushVO.getMsg());
        parm.put("title",jpushVO.getTitle());
        parm.put("alias",jpushVO.getAlias());
        parm.put("id",jpushVO.getId());
        Result result = JpushUtil.jpushAndroid(parm);
        log.info("极光推送，{}",result);
        return ResponseEntity.ok(result);
    }
}