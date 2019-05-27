package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SuperviseInfoMainOldDao extends Mapper<SuperviseInfoMainOld> {


    /**
     * 保存线下监管业务主表
     * @param superviseInfoMainOld
     */
    String saveSuperviseInfoMainOld(@Param("superviseInfoMainOld") SuperviseInfoMainOld superviseInfoMainOld);
}
