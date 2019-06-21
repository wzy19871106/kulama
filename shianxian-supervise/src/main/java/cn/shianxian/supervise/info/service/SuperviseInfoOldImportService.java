package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoOldImport;

public interface SuperviseInfoOldImportService {

    /**
     * 保存线下监管文件
     * @param superviseInfoOldImport
     * @return
     */
    Result saveSuperviseInfoOldImport(SuperviseInfoOldImport superviseInfoOldImport);


    /**
     * 根据时间查询文件导入信息表
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoOldImport(QueryPojo queryPojo, Pages pages);
}
