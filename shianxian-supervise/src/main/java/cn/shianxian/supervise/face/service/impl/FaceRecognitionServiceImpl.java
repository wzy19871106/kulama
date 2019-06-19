package cn.shianxian.supervise.face.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.CommonUtils;
import cn.shianxian.supervise.common.utils.FaceUtils;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.face.dao.FaceRecognitionDao;
import cn.shianxian.supervise.face.pojo.FaceRecognition;
import cn.shianxian.supervise.face.service.FaceRecognitionService;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.sys.dao.PicInfoDao;
import cn.shianxian.supervise.sys.pojo.PicInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FaceRecognitionServiceImpl implements FaceRecognitionService {


    @Autowired
    private FaceRecognitionDao faceRecognitionDao;


    @Autowired
    private FunctionaryDao functionaryDao;


    @Autowired
    private PicInfoDao picInfoDao;


    @Value("${agora.appId}")
    private String appId;


    @Value("${agora.sdkKey}")
    private String sdkKey;


    @Value("${agora.path}")
    private String path;


    @Value("${upload.path}")
    private String uploadPath;


    @Transactional
    @Override
    public ResponseEntity<Result> saveFaceRecognition(FaceRecognition faceRecognition) {
        if (null == faceRecognition.getFaceTag()) {
            this.faceRecognitionDao.insertSelective(faceRecognition);
            Functionary functionary = new Functionary();
            functionary.setFunctionaryTag(faceRecognition.getFunctionaryTag());
            functionary.setFaceTag(faceRecognition.getFaceTag());
            this.functionaryDao.updateByPrimaryKeySelective(functionary);
        } else {
            this.faceRecognitionDao.updateByPrimaryKeySelective(faceRecognition);
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> deleteFaceRecognition(Long faceTag) {
        this.faceRecognitionDao.deleteByPrimaryKey(faceTag);
        return ResponseEntity.ok(Result.successMsg());
    }



    @Override
    public ResponseEntity<Result> selectFaceRecognition(Long faceTag) {
        List<FaceRecognition> faceRecognitions = new ArrayList<>();
        if (null == faceTag) {
            faceRecognitions = this.faceRecognitionDao.selectAll();
        } else {
            FaceRecognition faceRecognition = this.faceRecognitionDao.selectByPrimaryKey(faceTag);
            faceRecognitions.add(faceRecognition);
        }
        return ResponseEntity.ok(Result.data(faceRecognitions));
    }


    @Override
    public ResponseEntity<Result> faceRecognition(MultipartFile file, String functionaryTag) throws IOException {
        Functionary functionary = this.functionaryDao.selectByPrimaryKey(functionaryTag);
        // 判断证件照是否存在，不存在则人脸识别失败
        if (null != functionary && StringUtils.isNotBlank(functionary.getPicTag())) {
            PicInfo picInfo = new PicInfo();
            picInfo.setPicTag(functionary.getPicTag());
            List<PicInfo> picInfos = this.picInfoDao.select(picInfo);
            if (!picInfos.isEmpty()) {
                String fileType = ".jpg.jpeg.png.JPG.JPEG.PNG";
                String fileSuffix = CommonUtils.getFileSuffix(file.getOriginalFilename());
                if (!fileType.contains(fileSuffix)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.msg("请上传图片！"));
                }
                String fileName = UUIDGenerator.generatorUUID();
                File filePath = new File(path);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                    log.info("创建文件夹：{}", path);
                }
                File tmpFile = new File(path + fileName + fileSuffix);
                file.transferTo(tmpFile);
                for (PicInfo info : picInfos) {
                    File tmpFile2 = new File(uploadPath + info.getPicAddress());
                    if (tmpFile2.exists()) {
                        boolean result = FaceUtils.faceEngine(appId, sdkKey, tmpFile, tmpFile2);
                        if (result) {
                            return ResponseEntity.ok(Result.data(result));
                        }
                    }
                }
            }
        }
        return ResponseEntity.ok(Result.data(false));
    }
}
