package cn.shianxian.supervise.tibetan.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.pojo.XsMain;
import cn.shianxian.supervise.tibetan.vo.XsInfoSaveVO;
import cn.shianxian.supervise.tibetan.vo.XsInfoVO;
import cn.shianxian.supervise.tibetan.vo.XsMainInfoVO;

import java.util.List;

public interface XsInfoService {
    /**
     *插入销售信息
     * @param
     * @return
     */
    Result saveSalesInfo(XsInfoSaveVO xsInfoVO);

    /**
     * 根据各种条件查询销售信息
     *
     * @return
     */
    Result selectXsInfo(XsMain xsMain);

    /**
     * 插入销售金额
     * @param xsInfoVO
     * @return
     */
    Result saveAmount(XsMainInfoVO xsInfoVO);

    /**
     * 根据销售上下家编码修改巡视意见
     * @param xsMains
     * @return
     */
    Result updateCheckByXsdm(XsMain xsMains);

    /**
     * 根据销售编码查询是否有记录
     * @param xsrq
     * @param xszje
     * @param xsdm
     * @return
     */
    Result selectXsMainIfRecord(String xsrq,String xszje,String xsdm);
}
