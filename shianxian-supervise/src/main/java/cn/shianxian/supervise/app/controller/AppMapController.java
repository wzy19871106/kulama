package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.service.MapService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;


/**
 * app地图
 */
@RestController
@RequestMapping("app/map")
@Api(description = "app地图控制器")
@Slf4j
public class AppMapController {


    @Autowired
    private MapService mapService;


    @Value("${baidu.url.geocoding}")
    private String urlGeocoding;


    /**
     * 保存执法人员位置
     * @return
     */
    @PostMapping("site")
    @ApiOperation(value = "保存执法人员位置", notes = "保存执法人员位置")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业id"),
            @ApiImplicitParam(paramType = "query", name = "site", value = "位置"),
    })
    public ResponseEntity<Result> saveSite(String nodeTag, String site) {
        log.info("保存执法人员位置，企业id：{}，位置：{}", nodeTag, site);
        Result result = this.mapService.saveSite(nodeTag, site);
        return ResponseEntity.ok(result);
    }


    /**
     * 通过位置获取经纬度
     * @return
     */
    @PostMapping("geocoding")
    @ApiOperation(value = "通过位置获取经纬度", notes = "通过位置获取经纬度")
    @ApiImplicitParam(paramType = "query", name = "address", value = "位置")
    public ResponseEntity<Result> geocoding(String address) {
        log.info("通过位置获取经纬度：{}", address);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        Map<Object, Object> map = Maps.newLinkedHashMap();
        map.put("address", address);
        String jsonStr = restTemplate.getForObject(urlGeocoding, String.class, map);
        // 格式化成json
        jsonStr = jsonStr.substring(jsonStr.lastIndexOf("(") + 1);
        String json = jsonStr.substring(0, jsonStr.lastIndexOf(")"));
        JSONObject jsonObject = JSONObject.parseObject(json);
        int status = (int) jsonObject.get("status");
        if (0 != status) {
            return ResponseEntity.ok(Result.msg(Constants.ZERO, "没有获取到经纬度！"));
        }
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject location = result.getJSONObject("location");
        Object lng = location.get("lng");
        Object lat = location.get("lat");
        Map<Object, Object> resultMap = Maps.newHashMap();
        resultMap.put("lng", lng);
        resultMap.put("lat", lat);
        return ResponseEntity.ok(Result.data(resultMap));
    }


}
