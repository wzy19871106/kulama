package cn.shianxian.supervise.face.service;

import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    /**
     * 查询负责人备案图片
     * @param functionaryTag
     * @return
     * @throws IOException
     */
   Result selectPrincipalPicResultByFunctionaryTag(String functionaryTag) throws IOException;
}
