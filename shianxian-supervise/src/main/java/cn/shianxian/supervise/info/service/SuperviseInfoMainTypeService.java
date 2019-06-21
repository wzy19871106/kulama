package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;

public interface SuperviseInfoMainTypeService {


    /**
     * 保存监管业务主类型
     * @param superviseInfoMainType
     * @return
     */
    Result saveSuperviseInfoMainType(SuperviseInfoMainType superviseInfoMainType);


    /**
     * 根据主业务编码更新整改状态
     * @param mainIds
     * @return
     */
    Result updateSuperviseInfoMainType(String mainIds);
}
