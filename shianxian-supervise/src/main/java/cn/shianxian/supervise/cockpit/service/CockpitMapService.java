package cn.shianxian.supervise.cockpit.service;

import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;

public interface CockpitMapService {

    /**
     * 根据监管类型，考核周期，查询驾驶舱数据
     * @param queryPojo
     * @return
     */
    ResponseEntity<Result> selectCockpitMap(QueryPojo queryPojo);

}
