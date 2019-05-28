package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.vo.RectifySumVO;
import cn.shianxian.supervise.info.vo.SuperviseInfoScoreVO;
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
    List<List<?>> selectSuperviseInfoDetailById(@Param("id") String id, @Param("pages") Pages pages);


    /**
     * 根据监管编码返回待整改的监管内容的整改意见
     * @param id
     * @return
     */
    List<List<?>> selectSuperviseInfoAdviceById(@Param("id") String id);


    /**
     * 根据监管业务（主类型）表的ID查询该ID的上级监管内容相关信息
     * @param id
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoSubParentId(@Param("id") String id, @Param("pages") Pages pages);


    /**
     * 根据监管业务（主类型）表的ID查询及该ID的上级监管内容ID查询下级监管内容的相关信息
     * @param id
     */
    List<List<?>> selectSuperviseInfoSubId(@Param("superviseTag") String superviseTag, @Param("id") String id);


    /**
     * 根据监管业务（主类型）表的ID查询该ID的得分以及总分值
     * @param id
     * @return
     */
    SuperviseInfoScoreVO selectSuperviseInfoSubScoreId(@Param("id") String id);


    /**
     * 获取整改意见内容
     * @param id
     * @param pages
     * @return
     */
    List<List<?>> selectRectify(@Param("id") String id, @Param("pages") Pages pages);


    /**
     * 获取整改意见详情
     * @param superviseTag
     * @param id
     * @return
     */
    List<List<?>> selectRectifyDetail(@Param("superviseTag") String superviseTag, @Param("id") String id);


    /**
     * 获取整改意见汇总
     * @param id
     * @return
     */
    RectifySumVO selectRectifySum(@Param("id") String id);
}
