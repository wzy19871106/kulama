package cn.shianxian.supervise.team.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.team.pojo.Superviser;
import org.springframework.http.ResponseEntity;

public interface SuperviserService {


    /**
     * 保存执法人员
     * @param superviser
     * @return
     */
    Result saveSuperviser(Superviser superviser);


    /**
     * 修改执法人员
     * @param superviser
     * @return
     */
    Result updateSuperviser(Superviser superviser);


    /**
     * 删除执法人员
     * @param ids
     * @return
     */
    ResponseEntity<Result> deleteSuperviserById(String ids);


    /**
     * 查询执法人员
     * @param queryPojo
     * @return
     */
    Result selectSuperviser(QueryPojo queryPojo, Pages pages);


    /**
     * 绑定执法人员
     * @param superviser
     * @return
     */
    Result bindSuperviser(Superviser superviser);
}
