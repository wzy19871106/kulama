package cn.shianxian.supervise.face.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.face.pojo.FaceRecognition;
import org.springframework.http.ResponseEntity;

public interface FaceRecognitionService {


    /**
     * 保存、修改人脸识别
     * @param faceRecognition
     * @return
     */
    ResponseEntity<Result> saveFaceRecognition(FaceRecognition faceRecognition);


    /**
     * 删除人脸识别
     * @param faceTag
     * @return
     */
    ResponseEntity<Result> deleteFaceRecognition(Long faceTag);


    /**
     * 查询人脸识别
     * @param faceTag
     * @return
     */
    ResponseEntity<Result> selectFaceRecognition(Long faceTag);
}
