package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.PicTagCutoutUtils;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoSubService;
import cn.shianxian.supervise.info.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
            // 判断是否多张图片
            if (infoSub.getPicTag().indexOf(",") != -1){
            // 去掉 , 号
            String[] splits = infoSub.getPicTag().split(",");
            StringBuilder sb = new StringBuilder();
            if (splits != null && splits.length > 0) {
                for (String split : splits) {
                    // 判断是否是反馈
                    if (split.indexOf("反馈") != -1) {
                        // 截掉前三个字符  反馈:
                        String substring = split.substring(3);
                        String sub = substring + ",";
                        sb.append(sub);
                    }
                }
            } else {
                // 判断是否是反馈
                if (infoSub.getPicTag().indexOf("反馈") != -1) {
                    // 截掉前三个字符  反馈:
                    String substring = infoSub.getPicTag().substring(3);
                    String sub = substring + ",";
                    sb.append(sub);
                }
            }
                infoSub.setPicTag(sb.toString());
                return Result.data(infoSub);
            }
        }
        return Result.failMsg();
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
        String advice = this.superviseInfoSubDao.selectSuperviseInfoAdviceById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("advice", advice);
        return Result.data(map);
    }


    @Override
    public Result selectSuperviseInfoDetailTree(String id, Pages pages) {
        SuperviseInfoTreeVO tree = new SuperviseInfoTreeVO();
        // 获取监管内容
        List<List<?>> superviseVOS = this.superviseInfoSubDao.selectSuperviseInfoSubParentId(id, pages);
        if (null != superviseVOS) {
            List<SuperviseVO> superviseVOList = (List<SuperviseVO>) superviseVOS.get(0);
            for (SuperviseVO superviseVO : superviseVOList) {
                if (StringUtils.isAnyBlank(superviseVO.getResultTag(), superviseVO.getResultValue())) {
                    List<List<?>> infoList = this.superviseInfoSubDao.selectSuperviseInfoSubId(superviseVO.getSuperviseTag(), id);
                    if (null != infoList) {
                        superviseVO.setInfoTreeList((List<SuperviseVO>) infoList.get(0));
                    }
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
                if (StringUtils.isAnyBlank(rectifyVO.getResultTag(), rectifyVO.getResultValue(), rectifyVO.getStatus(), rectifyVO.getSubId())) {
                    List<List<?>> rectifyDetail = this.superviseInfoSubDao.selectRectifyDetail(rectifyVO.getSuperviseTag(), id);
                    if (null != rectifyDetail) {
                        rectifyVO.setRectifyList((List<RectifyVO>) rectifyDetail.get(0));
                    }
                }
            }
            tree.setRectifys(rectifyVOList);
        }
        // 获取汇总
        RectifySumVO rectifySum = this.superviseInfoSubDao.selectRectifySum(id);
        tree.setRectifySum(rectifySum);
        return Result.data(tree);
    }


    @Transactional
    @Override
    public Result saveSuperviseInfoSub(SuperviseInfoSub superviseInfoSub) {
        this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
        return Result.successMsg();
    }


    @Override
    public Result rectify(SuperviseInfoSub superviseInfoSub) {
        List<RectifyTimeVO> rectifyTimeList = this.superviseInfoSubDao.rectifyTime(superviseInfoSub);
        for (RectifyTimeVO time : rectifyTimeList) {
            RectifyResultVO result = this.superviseInfoSubDao.rectify(time.getMainIds());
            if (result != null) {
                // 所有监管项、
                List<SuperviseInfoSub> allList = this.superviseInfoSubDao.rectifyAndReformFeedback(time.getMainIds(), Constants.STATUS_NULL);
                if (!allList.isEmpty()) {
                    for (SuperviseInfoSub infoSub : allList) {
                        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
                            Map cutout = PicTagCutoutUtils.Cutout(infoSub.getPicTag());
                            infoSub.setFeedback((String) cutout.get("feedback"));
                            infoSub.setScreenshot((String) cutout.get("screenshot"));
                        }
                    }
                }
                result.setAllSuperviseInfoSubs(allList);

                // 已整改通过项
                List<SuperviseInfoSub> doneList = this.superviseInfoSubDao.rectifyAndReformFeedback(time.getMainIds(), Constants.STATUS_NOE);
                if (!doneList.isEmpty()) {
                    for (SuperviseInfoSub infoSub : doneList) {
                        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
                            Map cutout = PicTagCutoutUtils.Cutout(infoSub.getPicTag());
                            infoSub.setFeedback((String) cutout.get("feedback"));
                            infoSub.setScreenshot((String) cutout.get("screenshot"));
                        }
                    }
                }
                result.setDoneSuperviseInfoSubs(doneList);

                // 需监管项
                List<SuperviseInfoSub> ontList = this.superviseInfoSubDao.rectifyAndReformFeedback(time.getMainIds(), Constants.STATUS_TWO_THREE);
                if (!ontList.isEmpty()) {
                    for (SuperviseInfoSub infoSub : ontList) {
                        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
                            Map cutout = PicTagCutoutUtils.Cutout(infoSub.getPicTag());
                            infoSub.setFeedback((String) cutout.get("feedback"));
                            infoSub.setScreenshot((String) cutout.get("screenshot"));
                        }
                    }
                }
                result.setNotSuperviseInfoSubs(ontList);
                // 已整改未监管项
                List<SuperviseInfoSub> doneRectifyList = this.superviseInfoSubDao.rectifyAndReformFeedback(time.getMainIds(), Constants.STATUS_THREE);
                if (!doneRectifyList.isEmpty()) {
                    for (SuperviseInfoSub infoSub : doneRectifyList) {
                        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
                            Map cutout = PicTagCutoutUtils.Cutout(infoSub.getPicTag());
                            infoSub.setFeedback((String) cutout.get("feedback"));
                            infoSub.setScreenshot((String) cutout.get("screenshot"));
                        }
                    }
                }
                result.setDoneRectifyNotSuperviseInfoSub(doneRectifyList);
                // 未整改未监管项
                List<SuperviseInfoSub> notRectifyList = this.superviseInfoSubDao.rectifyAndReformFeedback(time.getMainIds(), Constants.STATUS_TWO);
                if (!notRectifyList.isEmpty()) {
                    for (SuperviseInfoSub infoSub : notRectifyList) {
                        if (StringUtils.isNotBlank(infoSub.getPicTag())) {
                            Map cutout = PicTagCutoutUtils.Cutout(infoSub.getPicTag());
                            infoSub.setFeedback((String) cutout.get("feedback"));
                            infoSub.setScreenshot((String) cutout.get("screenshot"));
                        }
                    }
                }
                result.setNotRectifyNotSuperviseInfoSub(notRectifyList);
                time.setRectifyResults(result);
            }
        }
        return Result.data(rectifyTimeList);
    }

}
