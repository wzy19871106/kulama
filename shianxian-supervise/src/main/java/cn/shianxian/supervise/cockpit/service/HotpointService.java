package cn.shianxian.supervise.cockpit.service;

import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface HotpointService {


    /**
     * 根据时间段，企业编码，返回所需汇总数据
     * @return
     */
    ResponseEntity<Result> selectHotpoint(String superviseTypeTag);

    /**
     * 查询所有监管类型
     * @return
     */
    ResponseEntity<Result> selectAllSuperviseType();

    /**
     * 查询所有区县
     * @return
     */
    ResponseEntity<Result> selectAllArea();


}
