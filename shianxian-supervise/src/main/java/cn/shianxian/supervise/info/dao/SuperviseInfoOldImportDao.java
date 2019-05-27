package cn.shianxian.supervise.info.dao;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOldImport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SuperviseInfoOldImportDao extends Mapper<SuperviseInfoOldImport> {


    /**
     * 保存线下监管文件
     * @param superviseInfoOldImport
     */
    String saveSuperviseInfoOldImport(@Param("superviseInfoOldImport") SuperviseInfoOldImport superviseInfoOldImport);


    /**
     * 根据时间查询文件导入信息表
     * @param queryPojo
     * @param pages
     * @return
     */
    List<List<?>> selectSuperviseInfoOldImport(@Param("queryPojo") QueryPojo queryPojo, @Param("pages") Pages pages);
}
