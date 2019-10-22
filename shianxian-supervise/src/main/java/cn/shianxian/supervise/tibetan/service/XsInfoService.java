package cn.shianxian.supervise.tibetan.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.dto.XsInfoDTO;

import java.util.List;

public interface XsInfoService {
    /**
     *插入销售信息
     * @param xsInfoDTO
     * @return
     */
    Result saveSalesInfo(List<XsInfoDTO> xsInfoDTO);

    /**
     * 根据下家编码查询
     * @param xssjdm
     * @param xsxjdm
     * @param xschecked
     * @return
     */
    Result selectXsInfo(String xssjdm,String xsxjdm,String xschecked);
}
