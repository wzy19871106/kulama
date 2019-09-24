package cn.shianxian.supervise.face.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.Base64Utils;
import cn.shianxian.supervise.common.utils.CommonUtils;
import cn.shianxian.supervise.common.utils.FaceUtils;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FaceRecognitionServiceImpl implements FaceRecognitionService {


    @Autowired
    private FunctionaryDao functionaryDao;


    @Autowired
    private PicInfoDao picInfoDao;


    @Value("${arcsoft.appId}")
    private String appId;


    @Value("${arcsoft.sdkKey}")
    private String sdkKey;


    @Value("${arcsoft.path}")
    private String path;


    @Value("${arcsoft.libPath}")
    private String libPath;


    @Value("${upload.path}")
    private String uploadPath;


    @Override
    public ResponseEntity<Result> faceRecognition(String img, String functionaryTag) throws IOException {
        Functionary functionary = this.functionaryDao.selectByPrimaryKey(functionaryTag);
        // 判断证件照是否存在，不存在则人脸识别失败
        if (null != functionary && StringUtils.isNotBlank(functionary.getPicTag())) {
            PicInfo picInfo = new PicInfo();
            picInfo.setPicTag(functionary.getPicTag());
            picInfo.setPicName("注册人脸");
            List<PicInfo> picInfos = this.picInfoDao.select(picInfo);
            if (!picInfos.isEmpty()) {
                File filePath = new File(path);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                    log.info("创建文件夹：{}", path);
                }
                File file = Base64Utils.GenerateImage(img, path);
                if (null != file) {
                    for (PicInfo info : picInfos) {
                        File file2 = new File(uploadPath + info.getPicAddress());
                        if (file2.exists()) {
//                            boolean result = FaceUtils.face(appId, sdkKey, libPath, file, file2);
                            Map<Object,Object> face = FaceUtils.face(appId, sdkKey, libPath, file, file2);
                            return ResponseEntity.ok(Result.data(face));
                        }
                    }
                }
            }
        }
        return ResponseEntity.ok(Result.data(false));
    }


    @Override
    public ResponseEntity<Result> checlFace(String functionaryTag, MultipartFile file) throws IOException {
        Functionary functionary = this.functionaryDao.selectByPrimaryKey(functionaryTag);
        // 判断证件照是否存在，不存在则人脸识别失败
        if (null != functionary && StringUtils.isNotBlank(functionary.getPicTag())) {
            PicInfo picInfo = new PicInfo();
            picInfo.setPicTag(functionary.getPicTag());
            picInfo.setPicName("注册人脸");
            List<PicInfo> picInfos = this.picInfoDao.select(picInfo);
            if (!picInfos.isEmpty()) {
                File filePath = new File(path);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                    log.info("创建文件夹：{}", path);
                }
                String fileSuffix = CommonUtils.getFileSuffix(file.getOriginalFilename());
                String fileType = ".jpg.jpeg.png.JPG.JPEG.PNG";
                if (!fileType.contains(fileSuffix)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.msg("请上传图片！"));
                }
                File temp = new File(filePath + UUIDGenerator.generatorUUID() + fileSuffix);
                file.transferTo(temp);
                if (null != file) {
                    for (PicInfo info : picInfos) {
                        File file2 = new File(uploadPath + info.getPicAddress());
                        if (file2.exists()) {
//                           boolean result = FaceUtils.face(appId, sdkKey, libPath, temp, file2);
                            Map<Object,Object> face = FaceUtils.face(appId, sdkKey, libPath, temp, file2);
                            return ResponseEntity.ok(Result.data(face));
                        }
                    }
                }
            }
        }
        return ResponseEntity.ok(Result.data(false));
    }

    @Override
    public  Result selectPrincipalPicResultByFunctionaryTag(String functionaryTag) throws IOException {
        Functionary functionary = this.functionaryDao.selectByPrimaryKey(functionaryTag);
        // 判断证件照是否存在
        if (null != functionary && StringUtils.isNotBlank(functionary.getPicTag())) {
            PicInfo picInfo = new PicInfo();
            picInfo.setPicTag(functionary.getPicTag());
            picInfo.setPicName("注册人脸");
            List<PicInfo> picInfos = this.picInfoDao.select(picInfo);
            if (!picInfos.isEmpty()) {
                for (PicInfo info : picInfos) {
                    String fileURL = uploadPath + info.getPicAddress();
                    return Result.data(fileURL);
                }
            }
        }
        return Result.msg("无负责人备案照片");
    }
}
