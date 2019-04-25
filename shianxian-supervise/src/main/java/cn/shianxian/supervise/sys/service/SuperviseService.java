package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.pojo.Supervise;

public interface SuperviseService {


    /**
     * 查询监管内容
     * @param supervise
     * @return
     */
    Result selectSupervise(Supervise supervise);


    /**
     * 保存、修改监管内容
     * @param supervise
     * @return
     */
    Result saveOrUpdateSupervise(Supervise supervise);


    /**
     * 删除监管内容
     * @param ids
     * @return
     */
    Result deleteSuperviseById(String ids);


    /**
     * 修改监管内容排序
     * @param id
     * @param type
     * @return
     */
    Result updateSuperviseBySort(String id, int type);


    /**
     * 查询监管内容剩余分值
     * @param id
     * @return
     */
    Result selectSuperviseScore(String id);
}
