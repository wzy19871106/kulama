package cn.shianxian.supervise.information.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.information.pojo.Information;
import org.springframework.http.ResponseEntity;

public interface InformationService {


    /**
     * 保存、修改政企互动信息
     * @param information
     * @return
     */
    ResponseEntity<Result> saveInformation(Information information);


    /**
     * 删除政企互动信息
     * @param index
     * @return
     */
    ResponseEntity<Result> deleteInformation(Long index);


    /**
     * 查询政企互动信息
     * @param queryPojo
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectInformation(QueryPojo queryPojo, Pages pages);


    /**
     * 根据id查询政企互动信息
     * @param index
     * @return
     */
    ResponseEntity<Result> selectInformationById(String index);


    /**
     * 修改政企互动信息置顶
     * @param index
     * @param type
     * @return
     */
    ResponseEntity<Result> updateInformationTop(String index, int type);
}
