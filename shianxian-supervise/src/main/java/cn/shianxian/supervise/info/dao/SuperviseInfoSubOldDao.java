package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.info.pojo.SuperviseInfoSubOld;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseInfoSubOldDao extends Mapper<SuperviseInfoSubOld> {


    /**
     * 根据所选监管业务编码和监管类型查询监管结果详细信息
     * @param superviseInfoSubOld
     * @return
     */
    List<SuperviseInfoSubOld> selectSuperviseInfoOldDetail(@Param("superviseInfoSubOld") SuperviseInfoSubOld superviseInfoSubOld);


    /**
     * 保存线下监管业务从表
     * @param superviseInfoSubOld
     * @return
     */
    String saveSuperviseInfoSubOld(@Param("superviseInfoSubOld") SuperviseInfoSubOld superviseInfoSubOld);
}
