package cn.shianxian.supervise.cockpit.service;

import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface CockpitDistrictService {


    /**
     * 查询监管所信息
     * @return
     */
    ResponseEntity<Result> selectDistrictInfo();


}
