package cn.shianxian.supervise.sys.dao;

import cn.shianxian.supervise.sys.dto.SuperviseResultDTO;
import cn.shianxian.supervise.sys.pojo.SuperviseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseResultDao extends Mapper<SuperviseResult> {


    /**
     * 保存监管结果
     * @param superviseResult
     * @return
     */
    String insertSuperviseResult(@Param("superviseResult") SuperviseResult superviseResult);


    /**
     * 修改监管结果
     * @param superviseResult
     * @return
     */
    String updateSuperviseResult(@Param("superviseResult") SuperviseResult superviseResult);


    /**
     * 删除监管结果
     * @param id
     * @return
     */
    String deleteSuperviseResult(@Param("id") String id);


    /**
     * 根据id查询监管结果
     * @param id
     * @return
     */
    List<SuperviseResult> selectSuperviseResultById(@Param("id") String id);


    /**
     * 根据监管类型返回所有监管选项结果
     * @param id
     * @return
     */
    List<SuperviseResultDTO> selectSuperviseResultByTypeId(@Param("id") String id);


    /**
     * 根据监管内容编码查询监管结果
     * @param id
     * @return
     */
    List<SuperviseResult> selectSuperviseResultBySuperviseTag(@Param("id") String id);


    /**
     * 监管结果向上排序
     * @param id
     * @return
     */
    String updateSuperviseResultByUpSort(@Param("id") String id);


    /**
     * 监管结果向下排序
     * @param id
     * @return
     */
    String updateSuperviseResultByDownSort(@Param("id") String id);


}
