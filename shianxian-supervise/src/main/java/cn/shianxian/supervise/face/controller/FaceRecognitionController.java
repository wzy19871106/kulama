package cn.shianxian.supervise.face.controller;

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
 * 人脸识别控制器
 */
@RestController
@RequestMapping("faceRecognition")
@Api(description = "人脸识别控制器")
@Slf4j
public class FaceRecognitionController {



    @Autowired
    private FaceRecognitionService faceRecognitionService;


    /**
     * 人脸识别
     * @return
     */
    @PostMapping("faceRecognition")
    @ApiOperation(value = "人脸识别", notes = "人脸识别")
    @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人标识")
    public ResponseEntity<Result> faceRecognition(@ApiParam(value = "图片1", required = true) MultipartFile file, String functionaryTag) throws IOException {
        return this.faceRecognitionService.faceRecognition(file, functionaryTag);
    }


}
