package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.SuperviseType;

public interface SuperviseTypeService {


    /**
     * 保存、修改监管类型控制器
     * @param superviseType
     * @return
     */
    Result saveOrUpdateSuperviseType(SuperviseType superviseType);


    /**
     * 删除监管类型
     * @param id
     * @return
     */
    Result deleteSuperviseTypeById(String id);
}
