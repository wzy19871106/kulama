package cn.shianxian.supersive.agora.controller;


import cn.shianxian.supersive.common.pojo.Result;
import cn.shianxian.supersive.common.utils.DateUtils;
import cn.shianxian.supersive.common.utils.SignalingUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * 声网控制器
 */
@RestController
@RequestMapping("agora")
@Api(description = "声网控制器")
public class AgoraController {


    @Value("${agora.appid}")
    private String appId;


    @Value("${agora.certificate}")
    private String certificate;


    @Value("${agora.account}")
    private String account;


    /**
     * 获取token
     * @return
     */
    @GetMapping("getToken")
    @ApiOperation(value = "获取token接口", notes = "获取token接口")
    public ResponseEntity<Result> getToken() throws NoSuchAlgorithmException {
        String token = SignalingUtils.getToken(appId, certificate, account, DateUtils.getTimestamp());
        return ResponseEntity.ok(Result.data(token));
    }

}
