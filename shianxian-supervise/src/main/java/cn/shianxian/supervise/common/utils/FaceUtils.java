package cn.shianxian.supervise.common.utils;


import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;


@Slf4j
public class FaceUtils {


    public static Map face(String appId, String sdkKey, String libPath, File file1, File file2) {
        log.info("人脸识别图片1：{}", file1.getPath());
        log.info("人脸识别图片2：{}", file2.getPath());
        List list = new ArrayList();
        Map<Object,Object> map = new HashMap();
        boolean flag = false;
        FaceEngine faceEngine = new FaceEngine(libPath);
        // 激活引擎
        int activeCode = faceEngine.activeOnline(appId, sdkKey);

        if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            log.info("虹软引擎激活失败");
        }
        // 引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);
        // 功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);
        // 初始化引擎
        int initCode = faceEngine.init(engineConfiguration);
        if (initCode != ErrorInfo.MOK.getValue()) {
            log.info("虹软初始化引擎失败");
        }
        // 人脸检测
        ImageInfo imageInfo = getRGBData(file1);
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
        // 人脸检测2
        ImageInfo imageInfo2 = getRGBData(file2);
        List<FaceInfo> faceInfoList2 = new ArrayList<FaceInfo>();
        faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2);

        if (faceInfoList.isEmpty() || faceInfoList2.isEmpty()) {
            log.info("没有人脸信息");
            map.put("flag",false);
            return map;
        }
        // 特征提取
        FaceFeature faceFeature = new FaceFeature();
        faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
        // 特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2.get(0), faceFeature2);
        // 特征比对
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
        FaceSimilar faceSimilar = new FaceSimilar();
        faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
        log.info("相似度：{}", faceSimilar.getScore());
        if (Math.abs(0.6) < Math.abs(faceSimilar.getScore())) {
            flag = true;
        }
        faceEngine.unInit();
        float score = faceSimilar.getScore();
        map.put("flag",true);
        map.put("score",score);
        // 引擎卸载
        return map;
    }

}
