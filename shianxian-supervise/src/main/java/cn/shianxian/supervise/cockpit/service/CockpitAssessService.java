package cn.shianxian.supervise.cockpit.service;

import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface CockpitAssessService {

    /**
     * 查询驾驶舱考核评议数据
     *
     * @return
     */
    ResponseEntity<Result> selectCockpitAssess();

}
