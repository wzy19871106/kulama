package cn.shianxian.supervise.face.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.face.dao.FaceRecognitionDao;
import cn.shianxian.supervise.face.pojo.FaceRecognition;
import cn.shianxian.supervise.face.service.FaceRecognitionService;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceRecognitionServiceImpl implements FaceRecognitionService {


    @Autowired
    private FaceRecognitionDao faceRecognitionDao;


    @Autowired
    private FunctionaryDao functionaryDao;


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
}
