package cn.shianxian.supervise.app.controller;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.face.pojo.FaceRecognition;
import cn.shianxian.supervise.face.service.FaceRecognitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * 保存、修改人脸识别
     * @return
     */
    @PostMapping("saveFaceRecognition")
    @ApiOperation(value = "保存、修改人脸识别", notes = "保存、修改人脸识别")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "faceTag", value = "id"),
            @ApiImplicitParam(paramType = "query", name = "eigenValue", value = "特征值"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "名称"),
            @ApiImplicitParam(paramType = "query", name = "picAddress", value = "图片路径"),
            @ApiImplicitParam(paramType = "query", name = "functionaryTag", value = "负责人id"),
    })
    public ResponseEntity<Result> saveFaceRecognition(@Valid FaceRecognition faceRecognition) {
        log.info("保存、修改人脸识别：{}", faceRecognition);
        return this.faceRecognitionService.saveFaceRecognition(faceRecognition);
    }


    /**
     * 删除人脸识别
     * @return
     */
    @PostMapping("deleteFaceRecognition")
    @ApiOperation(value = "删除人脸识别", notes = "删除人脸识别")
    @ApiImplicitParam(paramType = "query", name = "faceTag", value = "id")
    public ResponseEntity<Result> deleteFaceRecognition(@RequestParam() Long faceTag) {
        log.info("删除人脸识别：{}", faceTag);
        return this.faceRecognitionService.deleteFaceRecognition(faceTag);
    }


    /**
     * 查询人脸识别
     * @return
     */
    @PostMapping("selectFaceRecognition")
    @ApiOperation(value = "查询人脸识别", notes = "查询人脸识别")
    @ApiImplicitParam(paramType = "query", name = "faceTag", value = "id")
    public ResponseEntity<Result> selectFaceRecognition(Long faceTag) {
        log.info("查询人脸识别：{}", faceTag);
        return this.faceRecognitionService.selectFaceRecognition(faceTag);
    }

}
