package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.record.pojo.Functionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface FunctionaryDao extends Mapper<Functionary> {

    /**
     * 根据各种查询条件查询负责人
     *
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectFunctionaryByLike(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);


    /**
     * 根据企业标识查询负责人表
     *
     * @param nodeTag
     * @return
     */
    Functionary selectFunctionaryByNodeTag(@Param("nodeTag") String nodeTag);


    /**
     * 根据负责人标识查询负责人
     *
     * @param functionaryTag
     * @return
     */
    Functionary selectFunctionaryByFunctionaryTag(@Param("functionaryTag") String functionaryTag);


    /**
     * 根据微信标识查询负责人
     *
     * @param weChatId
     * @return
     */
    Functionary selectFunctionaryByWeChatId(@Param("weChatId") String weChatId);


    /**
     * 根据节点流水号删除负责人申请
     * @param index
     * @return
     */
    String deleteFunctionary(@Param("index") String index);
}
