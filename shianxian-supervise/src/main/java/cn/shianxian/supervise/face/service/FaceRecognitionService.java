package cn.shianxian.supervise.face.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.face.pojo.FaceRecognition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FaceRecognitionService {


    /**
     * 人脸识别
     * @param img
     * @param functionaryTag
     * @return
     */
    ResponseEntity<Result> faceRecognition(String img, String functionaryTag) throws IOException;


    /**
     * app人脸识别
     * @param file
     * @return
     */
    ResponseEntity<Result> checlFace(String functionaryTag, MultipartFile file) throws IOException;
}
