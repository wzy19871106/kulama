package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SuperviseInfoMainTypeDao extends Mapper<SuperviseInfoMainType> {


    /**
     * 保存监管业务主类型
     * @param superviseInfoMainType
     */
    String saveSuperviseInfoMainType(@Param("superviseInfoMainType") SuperviseInfoMainType superviseInfoMainType);


    /**
     * 根据主业务编码更新整改状态
     * @param mainIds
     */
    String updateSuperviseInfoMainType(@Param("mainIds") String mainIds);
}
