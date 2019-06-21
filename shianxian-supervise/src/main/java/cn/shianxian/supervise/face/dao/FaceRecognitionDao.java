package cn.shianxian.supervise.face.dao;

import cn.shianxian.supervise.face.pojo.FaceRecognition;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FaceRecognitionDao extends Mapper<FaceRecognition> {
}
