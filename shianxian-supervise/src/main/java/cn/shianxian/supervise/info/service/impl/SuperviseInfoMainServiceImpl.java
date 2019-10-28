package cn.shianxian.supervise.info.service.impl;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoMainTypeDao;
import cn.shianxian.supervise.info.dao.SuperviseInfoSubDao;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMainType;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import cn.shianxian.supervise.sys.dao.NodeInfoDao;
import cn.shianxian.supervise.sys.pojo.*;
import cn.shianxian.supervise.thread.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuperviseInfoMainServiceImpl implements SuperviseInfoMainService {


    @Autowired
    private SuperviseInfoMainDao superviseInfoMainDao;

    @Autowired
    private SuperviseInfoMainTypeDao superviseInfoMainTypeDao;

    @Autowired
    private SuperviseInfoSubDao superviseInfoSubDao;

    @Autowired
    private NodeInfoDao nodeInfoDao;

    @Value("${agora.recordFileRootDir}")
    private String recordFileRootDir;

    @Value("${upload.vourl}")
    private String uploadVourl;

    @Override
    public Result selectSuperviseInfoByNodePlan(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByNodePlan(nodeTag, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByIdPlan(String id, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByIdPlan(id, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByNode(String nodeTag, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByNode(nodeTag, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Transactional
    @Override
    public Result saveSuperviseInfoMain(SuperviseInfoMain superviseInfoMain) {
        this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
        return Result.successMsg();
    }


    @Override
    public Result selectSuperviseInfoByPlan(String planTag, String superviseTypeTag, QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByPlan(planTag, superviseTypeTag, queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByLike(queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Override
    public Result selectSuperviseInfoByRectify(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.superviseInfoMainDao.selectSuperviseInfoByRectify(queryPojo, pages);
        return Result.data((Long) list.get(2).get(0), list.get(0));
    }


    @Transactional
    @Override
    public Result saveSuperviseInfo(List<SuperviseType> superviseTypeList) {
        SuperviseInfoMain superviseInfoMain = new SuperviseInfoMain();
        boolean flag = true;
        String mainId = UUIDGenerator.generatorUUID();
        for (SuperviseType superviseType : superviseTypeList) {
            if (flag) {
                mainId = superviseType.getMainId();
                superviseInfoMain.setMainId(mainId);
                superviseInfoMain.setPlanTag(superviseType.getPlanTag());
                NodeInfo nodeInfo = this.nodeInfoDao.selectByPrimaryKey(superviseType.getNodeTag());
                superviseInfoMain.setNodeType(nodeInfo.getIndustryTag());
                superviseInfoMain.setNodeTag(superviseType.getNodeTag());
                superviseInfoMain.setNodeName(superviseType.getNodeName());
                superviseInfoMain.setCreateTime(LocalDateTime.now());
                superviseInfoMain.setPicTag("");
                superviseInfoMain.setIfOnline(superviseType.getIfOnline());
                // 保存监管主表
                this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
                flag = false;
            }
            SuperviseInfoMainType superviseInfoMainType = new SuperviseInfoMainType();
            String mainIds = UUIDGenerator.generatorUUID();
            superviseInfoMainType.setMainIds(mainIds);
            superviseInfoMainType.setMainId(mainId);
            superviseInfoMainType.setNodeTag(superviseType.getNodeTag());
            superviseInfoMainType.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
            superviseInfoMainType.setSuperviseTeamTag(superviseType.getSuperviseTeamTag());
            superviseInfoMainType.setSuperviseTeamName(superviseType.getSuperviseTeamName());
            superviseInfoMainType.setSuperviserTag(superviseType.getSuperviserTag());
            superviseInfoMainType.setSuperviserName(superviseType.getSuperviserName());
            superviseInfoMainType.setFunctionaryTag(superviseType.getFunctionaryTag());
            superviseInfoMainType.setFunctionaryName(superviseType.getFunctionaryName());
            superviseInfoMainType.setIfOnline(superviseType.getIfOnline());
            superviseInfoMainType.setIfVisit(superviseType.getIfVisit());
            if (StringUtils.isNotBlank(superviseType.getParentTag())) {
                superviseInfoMainType.setParentMainIds(superviseType.getParentTag());
            } else {
                superviseInfoMainType.setParentMainIds(null);
            }
            // 保存监管类型
            this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
            // 父级内容
            List<Supervise> superviseList = superviseType.getSuperviseList();
            for (Supervise supervise : superviseList) {
                List<SupervisePic> subList = supervise.getSuperviseList();
                sub:
                for (Supervise sub : subList) {
                    List<SuperviseResult> results = sub.getSuperviseResultList();
                    if (results.isEmpty()) {
                        continue sub;
                    }
                    SuperviseInfoSub superviseInfoSub = new SuperviseInfoSub();
                    superviseInfoSub.setMainIds(mainIds);
                    superviseInfoSub.setNodeTag(superviseType.getNodeTag());
                    superviseInfoSub.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
                    superviseInfoSub.setSuperviseTag(sub.getSuperviseTag());
                    superviseInfoSub.setSuperviseName(sub.getSuperviseName());
                    superviseInfoSub.setResultTag(results.get(0).getResultTag());
                    superviseInfoSub.setResultValue(results.get(0).getResultValue());
                    superviseInfoSub.setScore(results.get(0).getScore());
                    superviseInfoSub.setAdvice(results.get(0).getAdvice());
                    superviseInfoSub.setRequst("");
                    superviseInfoSub.setPicTag(sub.getPicTag());
                    superviseInfoSub.setCreateUserTag(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setLastUpdateUser(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setRemark(sub.getRemark());
                    // 保存监管从表
                    this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
                }
            }
            // 修改监管类型
            this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(superviseInfoMainType.getMainIds());
        }
        return Result.successMsg();
    }

    @Override
    @Transactional
    public Result saveSuperviseInfoApp(List<SuperviseType> superviseTypesList, HttpSession session) {
        SuperviseInfoMain superviseInfoMain = new SuperviseInfoMain();
        boolean flag = true;
        String mainId = UUIDGenerator.generatorUUID();
        for (SuperviseType superviseType : superviseTypesList) {
            if (flag) {
                mainId = superviseType.getMainId();
                superviseInfoMain.setMainId(mainId);
                superviseInfoMain.setPlanTag(superviseType.getPlanTag());
                NodeInfo nodeInfo = this.nodeInfoDao.selectByPrimaryKey(superviseType.getNodeTag());
                superviseInfoMain.setNodeType(nodeInfo.getIndustryTag());
                superviseInfoMain.setNodeTag(superviseType.getNodeTag());
                superviseInfoMain.setNodeName(superviseType.getNodeName());
                superviseInfoMain.setCreateTime(LocalDateTime.now());
                superviseInfoMain.setPicTag("");
                superviseInfoMain.setIfOnline(superviseType.getIfOnline());
                // 保存监管主表
                this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
                flag = false;
            }
            SuperviseInfoMainType superviseInfoMainType = new SuperviseInfoMainType();
            String mainIds = UUIDGenerator.generatorUUID();
            superviseInfoMainType.setMainIds(mainIds);
            superviseInfoMainType.setMainId(mainId);
            superviseInfoMainType.setNodeTag(superviseType.getNodeTag());
            superviseInfoMainType.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
            superviseInfoMainType.setSuperviseTeamTag(superviseType.getSuperviseTeamTag());
            superviseInfoMainType.setSuperviseTeamName(superviseType.getSuperviseTeamName());
            superviseInfoMainType.setSuperviserTag(superviseType.getSuperviserTag());
            superviseInfoMainType.setSuperviserName(superviseType.getSuperviserName());
            superviseInfoMainType.setFunctionaryTag(superviseType.getFunctionaryTag());
            superviseInfoMainType.setFunctionaryName(superviseType.getFunctionaryName());
            superviseInfoMainType.setIfOnline(superviseType.getIfOnline());
            superviseInfoMainType.setIfVisit(superviseType.getIfVisit());
            if (StringUtils.isNotBlank(superviseType.getParentTag())) {
                superviseInfoMainType.setParentMainIds(superviseType.getParentTag());
            } else {
                superviseInfoMainType.setParentMainIds(null);
            }
            // 保存监管类型
            this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
            // session中获取subId
            List<String> subIds = (List<String>) session.getAttribute("subId");
            for (String subId : subIds) {
                // 根据subId更新从表正式表
                this.superviseInfoSubDao.updateSuperviseInfoSub(subId);
            }
            // 修改监管类型
            this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(superviseInfoMainType.getMainIds());
        }
        return Result.successMsg();
    }

    @Transactional
    @Override
    public Result saveSuperviseInfoCheck(List<SuperviseType> superviseTypeList) {
        SuperviseInfoMain superviseInfoMain = new SuperviseInfoMain();
        boolean flag = true;
        String mainId = UUIDGenerator.generatorUUID();
        for (SuperviseType superviseType : superviseTypeList) {
            if (flag) {
                mainId = superviseType.getMainId();
                superviseInfoMain.setMainId(mainId);
                superviseInfoMain.setPlanTag(superviseType.getPlanTag());
                NodeInfo nodeInfo = this.nodeInfoDao.selectByPrimaryKey(superviseType.getNodeTag());
                superviseInfoMain.setNodeType(nodeInfo.getIndustryTag());
                superviseInfoMain.setNodeTag(superviseType.getNodeTag());
                superviseInfoMain.setNodeName(superviseType.getNodeName());
                superviseInfoMain.setCreateTime(LocalDateTime.now());
                superviseInfoMain.setPicTag("");
                superviseInfoMain.setIfOnline(superviseType.getIfOnline());
                // 保存监管主表
                this.superviseInfoMainDao.saveSuperviseInfoMain(superviseInfoMain);
                flag = false;
            }
            SuperviseInfoMainType superviseInfoMainType = new SuperviseInfoMainType();
            String mainIds = UUIDGenerator.generatorUUID();
            superviseInfoMainType.setMainIds(mainIds);
            superviseInfoMainType.setMainId(mainId);
            superviseInfoMainType.setNodeTag(superviseType.getNodeTag());
            superviseInfoMainType.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
            superviseInfoMainType.setSuperviseTeamTag(superviseType.getSuperviseTeamTag());
            superviseInfoMainType.setSuperviseTeamName(superviseType.getSuperviseTeamName());
            superviseInfoMainType.setSuperviserTag(superviseType.getSuperviserTag());
            superviseInfoMainType.setSuperviserName(superviseType.getSuperviserName());
            superviseInfoMainType.setFunctionaryTag(superviseType.getFunctionaryTag());
            superviseInfoMainType.setFunctionaryName(superviseType.getFunctionaryName());
            superviseInfoMainType.setIfOnline(superviseType.getIfOnline());
            superviseInfoMainType.setIfVisit(superviseType.getIfVisit());
            if (StringUtils.isNotBlank(superviseType.getParentTag())) {
                superviseInfoMainType.setParentMainIds(superviseType.getParentTag());
            } else {
                superviseInfoMainType.setParentMainIds(null);
            }
            // 保存监管类型
            this.superviseInfoMainTypeDao.saveSuperviseInfoMainType(superviseInfoMainType);
            // 父级内容
            List<Supervise> superviseList = superviseType.getSuperviseList();
            for (Supervise supervise : superviseList) {
                List<SupervisePic> subList = supervise.getSuperviseList();
                sub:
                for (Supervise sub : subList) {
                    List<SuperviseResult> results = sub.getSuperviseResultList();
                    if (results.isEmpty()) {
                        continue sub;
                    }
                    SuperviseInfoSub superviseInfoSub = new SuperviseInfoSub();
                    superviseInfoSub.setMainIds(mainIds);
                    superviseInfoSub.setNodeTag(superviseType.getNodeTag());
                    superviseInfoSub.setSuperviseTypeTag(superviseType.getSuperviseTypeTag());
                    superviseInfoSub.setSuperviseTag(sub.getSuperviseTag());
                    superviseInfoSub.setSuperviseName(sub.getSuperviseName());
                    superviseInfoSub.setResultTag(results.get(0).getResultTag());
                    superviseInfoSub.setResultValue(results.get(0).getResultValue());
                    superviseInfoSub.setScore(results.get(0).getScore());
                    superviseInfoSub.setAdvice(results.get(0).getAdvice());
                    superviseInfoSub.setRequst("");
                    superviseInfoSub.setPicTag(sub.getPicTag());
                    superviseInfoSub.setCreateUserTag(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setLastUpdateUser(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setRemark(sub.getRemark());
                    // 保存监管从表
                    this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
                }
            }
            List<SuperviseInfoSub> unCheckedList = superviseType.getUnCheckedList();
            if (!unCheckedList.isEmpty()) {
                for (SuperviseInfoSub unCheckedLists : unCheckedList) {
                    SuperviseInfoSub superviseInfoSub = new SuperviseInfoSub();
                    superviseInfoSub.setMainIds(mainIds);
                    superviseInfoSub.setNodeTag(unCheckedLists.getNodeTag());
                    superviseInfoSub.setSuperviseTypeTag(unCheckedLists.getSuperviseTypeTag());
                    superviseInfoSub.setSuperviseTag(unCheckedLists.getSuperviseTag());
                    superviseInfoSub.setSuperviseName(unCheckedLists.getSuperviseName());
                    superviseInfoSub.setResultTag(unCheckedLists.getResultTag());
                    superviseInfoSub.setResultValue(unCheckedLists.getResultValue());
                    superviseInfoSub.setScore(unCheckedLists.getScore());
                    superviseInfoSub.setCreateUserTag(UserThreadLocal.getUser().getUserTag());
                    superviseInfoSub.setLastUpdateUser(UserThreadLocal.getUser().getUserTag());
                    // 保存监管从表
                    this.superviseInfoSubDao.saveSuperviseInfoSub(superviseInfoSub);
                }
            }
            // 修改监管类型
            this.superviseInfoMainTypeDao.updateSuperviseInfoMainType(superviseInfoMainType.getMainIds());
        }
        return Result.successMsg();
    }


    @Override
    public Result getVideoUrl(String mainId) {
        String url = "";
        File folder = new File(recordFileRootDir + mainId);
        if (folder.exists() && !folder.isFile()) {
            File[] folderArr1 = folder.listFiles();
            a:
            for (File f1 : folderArr1) {
                File[] folderArr2 = f1.listFiles();
                for (File f2 : folderArr2) {
                    File[] folderArr3 = f2.listFiles();
                    for (File f3 : folderArr3) {
                        if (f3.getName().indexOf("mp4") != -1 || f3.getName().indexOf("MP4") != -1) {
                            url = f3.getAbsolutePath();
                            break a;
                        }
                    }
                }
            }
        }
        return Result.data(url.replace("/data/", uploadVourl));
    }


}
