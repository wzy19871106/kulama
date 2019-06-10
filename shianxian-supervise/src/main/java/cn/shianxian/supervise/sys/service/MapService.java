package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;

public interface MapService {


    /**
     * 保存执法人员位置
     * @param nodeTag
     * @param site
     * @return
     */
    Result saveSite(String nodeTag, String site);


    /**
     * 根据企业id获取企业位置，获取执法人员位置
     * @param nodeTag
     * @return
     */
    Result selectSite(String nodeTag);
}
