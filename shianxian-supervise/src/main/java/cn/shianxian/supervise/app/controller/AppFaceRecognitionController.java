package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.face.service.FaceRecognitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * app人脸识别控制器
 */
@RestController
@RequestMapping("app/faceRecognition")
@Api(description = "app人脸识别控制器")
@Slf4j
public class AppFaceRecognitionController {


    @Autowired
    private FaceRecognitionService faceRecognitionService;


    /**
     * app人脸识别
     * @return
     */
    @PostMapping("checlFace")
    @ApiOperation(value = "app人脸识别", notes = "app人脸识别")
    @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识")
    public ResponseEntity<Result> checlFace(@ApiParam(value = "图片", required = true) MultipartFile file, String functionaryTag) throws IOException {
        log.info("app人脸识别：{}", functionaryTag);
        return this.faceRecognitionService.checlFace(functionaryTag, file);
    }


}
