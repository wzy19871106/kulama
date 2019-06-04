package cn.shianxian.supervise.government.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.government.pojo.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface InformationDao extends Mapper<Information> {


    /**
     * 保存政企互动信息
     * @param information
     */
    String saveInformation(@Param("information") Information information);

    /**
     * 修改政企互动信息
     * @param information
     */
    String updateInformation(@Param("information") Information information);


    /**
     * 删除政企互动信息
     * @param index
     */
    String deleteInformation(@Param("index") Long index);


    /**
     * 查询政企互动信息
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectInformation(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 根据id查询政企互动信息
     * @param index
     * @return
     */
    Information selectInformationById(@Param("index") String index);


    /**
     * 政企互动信息置顶
     * @param index
     */
    String updateInformationTop(@Param("index") String index);


    /**
     * 政企互动信息取消置顶
     * @param index
     * @return
     */
    String updateInformationUnTop(@Param("index") String index);
}
