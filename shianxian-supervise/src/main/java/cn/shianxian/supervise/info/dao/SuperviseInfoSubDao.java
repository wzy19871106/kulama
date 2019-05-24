package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseInfoSubDao extends Mapper<SuperviseInfoSub> {


    /**
     * 根据节点id查询所有需整改监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseRectifyByNode(@Param("nodeTag") String nodeTag, @Param("pages")Pages pages);


    /**
     * 根据业务主类型编码查询该项下所有需整改项详细
     * @param id
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseRectifyById(@Param("id") String id, @Param("pages")Pages pages);


    /**
     * 根据id查询监管业务从表
     * @param id
     * @return
     */
    SuperviseInfoSub selectSuperviseInfoSubById(@Param("id") String id);


    /**
     * 根据id修改监管业务从表
     * @param superviseInfoSub
     * @return
     */
    String updateSuperviseInfoSubById(@Param("superviseInfoSub") SuperviseInfoSub superviseInfoSub);


    /**
     * 根据所选监管业务（主类型）编码查询监管明细
     * @param id
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoDetailById(String id, Pages pages);
}
