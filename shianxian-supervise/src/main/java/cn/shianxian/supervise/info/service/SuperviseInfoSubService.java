package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SuperviseInfoSubService {


    /**
     * 根据节点id查询所有需整改监管业务
     * @param nodeTag
     * @param pages
     * @return
     */
    Result selectSuperviseRectifyByNode(String nodeTag, Pages pages);


    /**
     * 根据业务主类型编码查询该项下所有需整改项详细
     * @param id
     * @param pages
     * @return
     */
    Result selectSuperviseRectifyById(String id, Pages pages);


    /**
     * 根据id查询监管业务从表
     * @param id
     * @return
     */
    Result selectSuperviseInfoSubById(String id);


    /**
     * 根据id修改监管业务从表
     * @param superviseInfoSub
     * @return
     */
    Result updateSuperviseInfoSubById(SuperviseInfoSub superviseInfoSub);


    /**
     * 根据所选监管业务（主类型）编码查询监管明细
     * @param id
     * @param pages
     * @return
     */
    Result selectSuperviseInfoDetailById(String id, Pages pages);


    /**
     * 根据监管编码返回待整改的监管内容的整改意见
     * @param id
     * @return
     */
    Result selectSuperviseInfoAdviceById(String id);


    /**
     * 根据所选监管业务（主类型）编码查询监管明细（树）
     * @param id
     * @param pages
     * @return
     */
    Result selectSuperviseInfoDetailTree(String id, Pages pages);


    /**
     * 根据业务主类型编码查询该项下所有需整改项详细（树）
     * @param id
     * @param pages
     * @return
     */
    Result selectSuperviseRectifyTree(String id, Pages pages);


    /**
     * 保存监管业务（从表）
     * @param superviseInfoSub
     * @return
     */
    Result saveSuperviseInfoSub(SuperviseInfoSub superviseInfoSub);


    /**
     * 查询整改情况
     * @param superviseInfoSub
     * @return
     */
    Result rectify(SuperviseInfoSub superviseInfoSub);

    /**
     * 保存监管业务（临时从表）
     * @param superviseInfoSubs
     * @return
     */
    Result saveSuperviseInfoSubTemp(List<SuperviseInfoSub> superviseInfoSubs, HttpSession session);
}
