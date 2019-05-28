package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
import cn.shianxian.supervise.info.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperviseInfoSubServiceImpl implements SuperviseInfoSubService {


    @Autowired
    private SuperviseInfoSubDao superviseInfoSubDao;


    @Override
    public Result selectSuperviseRectifyByNode(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseRectifyByNode(nodeTag, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseRectifyById(String id, Pages pages) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseRectifyById(id, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoSubById(String id) {
        SuperviseInfoSub infoSub = this.superviseInfoSubDao.selectSuperviseInfoSubById(id);
        return Result.data(infoSub);
    }


    @Transactional
    @Override
    public Result updateSuperviseInfoSubById(SuperviseInfoSub superviseInfoSub) {
        this.superviseInfoSubDao.updateSuperviseInfoSubById(superviseInfoSub);
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseInfoDetailById(String id, Pages pages) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseInfoDetailById(id, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoAdviceById(String id) {
        List<List<?>> list = this.superviseInfoSubDao.selectSuperviseInfoAdviceById(id);
        return Result.data(list);
    }


    @Override
    public Result selectSuperviseInfoDetailTree(String id, Pages pages) {
        SuperviseInfoTreeVO tree = new SuperviseInfoTreeVO();
        // 获取监管内容
        List<List<?>> superviseVOS = this.superviseInfoSubDao.selectSuperviseInfoSubParentId(id, pages);
        if (null != superviseVOS) {
            List<SuperviseVO> superviseVOList = (List<SuperviseVO>) superviseVOS.get(0);
            for (SuperviseVO superviseVO : superviseVOList) {
                List<List<?>> infoList = this.superviseInfoSubDao.selectSuperviseInfoSubId(superviseVO.getSuperviseTag(), id);
                if (null != infoList) {
                    superviseVO.setInfoTreeList((List<SuperviseVO>) infoList.get(0));
                }
            }
            tree.setSupervise(superviseVOList);
        }
        // 获取分数
        SuperviseInfoScoreVO score = this.superviseInfoSubDao.selectSuperviseInfoSubScoreId(id);
        tree.setScore(score);
        return Result.data(tree);
    }


    @Override
    public Result selectSuperviseRectifyTree(String id, Pages pages) {
        RectifyTreeVO tree = new RectifyTreeVO();
        // 获取整改建议内容
        List<List<?>> rectifys = this.superviseInfoSubDao.selectRectify(id, pages);
        if (null != rectifys) {
            List<RectifyVO> rectifyVOList = (List<RectifyVO>) rectifys.get(0);
            for (RectifyVO rectifyVO : rectifyVOList) {
                List<List<?>> rectifyDetail = this.superviseInfoSubDao.selectRectifyDetail(rectifyVO.getSuperviseTag(), id);
                if (null != rectifyDetail) {
                    rectifyVO.setDetailList((List<RectifyDetailVO>) rectifyDetail.get(0));
                }
            }
            tree.setRectifys(rectifyVOList);
        }
        // 获取汇总
        RectifySumVO rectifySum = this.superviseInfoSubDao.selectRectifySum(id);
        tree.setRectifySum(rectifySum);
        return Result.data(tree);
    }
}
