package cn.shianxian.supervise.government.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.government.pojo.Columned;
import org.springframework.http.ResponseEntity;

public interface ColumnedService {


    /**
     * 保存、修改栏目信息
     * @param columned
     * @return
     */
    ResponseEntity<Result> saveOrUpdateColumned(Columned columned);


    /**
     * 删除栏目信息
     * @param columnTag
     * @return
     */
    ResponseEntity<Result> deleteColumned(Long columnTag);


    /**
     * 查询栏目信息
     * @param name
     * @param pages
     * @return
     */
    ResponseEntity<Result> selectColumned(String name, Pages pages);


    /**
     * 根据id查询栏目信息
     * @param columnTag
     * @return
     */
    ResponseEntity<Result> selectColumnedById(Long columnTag);
}
