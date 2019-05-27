package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainOld;

public interface SuperviseInfoMainOldService {


    /**
     * 保存线下监管业务主表
     * @param superviseInfoMainOld
     * @return
     */
    Result saveSuperviseInfoMainOld(SuperviseInfoMainOld superviseInfoMainOld);
}
