package cn.shianxian.supervise.info.controller;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.info.pojo.SuperviseInfoMain;
import cn.shianxian.supervise.info.pojo.SuperviseInfoSub;
import cn.shianxian.supervise.info.service.SuperviseInfoMainService;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

/**
 * 监管业务（主表）控制器
 */
@RestController
@RequestMapping("sperviseInfoMain")
@Api(description = "监管业务（主表）控制器")
@Slf4j
public class SuperviseInfoMainController {


    @Autowired
    private SuperviseInfoMainService superviseInfoMainService;


    @Value("${agora.recordFileRootDir}")
    private String recordFileRootDir;


    /**
     * 保存监管业务（主表）
     *
     * @return
     */
    @PostMapping("superviseInfoMain")
    @ApiOperation(value = "保存监管业务（主表）", notes = "保存监管业务（主表）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务主键"),
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务编号（非计划任务监管可为空)"),
            @ApiImplicitParam(paramType = "query", name = "nodeType", value = "企业类型"),
            @ApiImplicitParam(paramType = "query", name = "nodeTag", value = "企业编码"),
            @ApiImplicitParam(paramType = "query", name = "nodeName", value = "企业名称"),
            @ApiImplicitParam(paramType = "query", name = "createTime", value = "监管日期"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "备注"),
            @ApiImplicitParam(paramType = "query", name = "picTag", value = "附件路径"),
            @ApiImplicitParam(paramType = "query", name = "ifDelete", value = "逻辑删除"),
    })
    public ResponseEntity<Result> saveSuperviseInfoMain(@Valid SuperviseInfoMain superviseInfoMain) {
        log.info("保存监管业务（主表）：{}", superviseInfoMain);
        Result result = this.superviseInfoMainService.saveSuperviseInfoMain(superviseInfoMain);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表
     *
     * @return
     */
    @GetMapping("selectSuperviseInfoByPlan")
    @ApiOperation(value = "根据登录用户的数据访问权限查询计划任务监管日志列表", notes = "根据登录用户的数据访问权限查询计划任务监管日志列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "planTag", value = "计划任务id"),
            @ApiImplicitParam(paramType = "query", name = "superviseTypeTag", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByPlan(String planTag, String superviseTypeTag, QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByPlan(planTag, superviseTypeTag, queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）
     *
     * @return
     */
    @GetMapping("selectSuperviseInfoByLike")
    @ApiOperation(value = "根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）", notes = "根据登录用户的数据访问权限查询计划任务监管日志列表（日常抽查）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByLike(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByLike(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示
     *
     * @return
     */
    @GetMapping("selectSuperviseInfoByRectify")
    @ApiOperation(value = "根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示", notes = "根据登录用户的数据访问权限及条件查询需要整改的监管列表，已企业，监管类型分组显示")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "监管类型id"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "关键字"),
            @ApiImplicitParam(paramType = "query", name = "authority", value = "权限"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "结束时间"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页查询数量"),
    })
    public ResponseEntity<Result> selectSuperviseInfoByRectify(QueryPojo queryPojo, Pages pages) {
        Result result = this.superviseInfoMainService.selectSuperviseInfoByRectify(queryPojo, pages);
        return ResponseEntity.ok(result);
    }


    /**
     * 保存监管业务
     *
     * @return
     */
    @PostMapping("saveSuperviseInfo")
    @ApiOperation(value = "保存监管业务", notes = "保存监管业务")
    public ResponseEntity<Result> saveSuperviseInfo(@RequestBody @Valid List<SuperviseType> superviseTypeList) {
        log.info("保存监管业务（主表）：{}", superviseTypeList);
        Result result = this.superviseInfoMainService.saveSuperviseInfo(superviseTypeList);
        return ResponseEntity.ok(result);
    }

    /**
     * 保存监管业务(未整改未监管项)
     *
     * @return
     */
    @PostMapping("saveNotSuperviseInfo")
    @ApiOperation(value = "保存监管业务(未整改未监管项)", notes = "保存监管业务(未整改未监管项)")
    public ResponseEntity<Result> saveSuperviseInfoCheck(@RequestBody @Valid List<?> JsonResult) {
        log.info("保存监管业务（主表-未整改未监管项）：{}", JsonResult);
        Result result = this.superviseInfoMainService.saveSuperviseInfoCheck(JsonResult);
        return ResponseEntity.ok(result);
    }

    /**
     * 获取播放视频url
     *
     * @return
     */
    @GetMapping("getVideoUrl")
    @ApiOperation(value = "获取播放视频url", notes = "获取播放视频url")
    @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务id")
    public ResponseEntity<Result> getVideoUrl(String mainId) {
        log.info("获取播放视频url：{}", mainId);
        Result result = this.superviseInfoMainService.getVideoUrl(mainId);
        return ResponseEntity.ok(result);
    }


    /**
     * 下载视频
     *
     * @return
     */
    @GetMapping("downloadVideo")
    @ApiOperation(value = "下载视频", notes = "下载视频")
    @ApiImplicitParam(paramType = "query", name = "mainId", value = "监管业务id")
    public ResponseEntity<Result> downloadVideo(String mainId, HttpServletResponse response, HttpServletRequest request) {
        log.info("下载视频：{}", mainId);
        File folder = new File(recordFileRootDir + mainId);
        if (folder.exists() && !folder.isFile()) {
            File file = null;
            File[] folderArr1 = folder.listFiles();
            a:
            for (File f1 : folderArr1) {
                File[] folderArr2 = f1.listFiles();
                for (File f2 : folderArr2) {
                    File[] folderArr3 = f2.listFiles();
                    for (File f3 : folderArr3) {
                        if (f3.getName().contains("mp4") || f3.getName().contains("MP4")) {
                            file = f3;
                            break a;
                        }
                    }
                }
            }
            // 清空输出流
            response.reset();
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setCharacterEncoding("UTF-8");
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new BufferedInputStream(new FileInputStream(file));
                os = new BufferedOutputStream(response.getOutputStream());
                //输出文件
                int bytes = 0;
                byte[] bufferOut = new byte[1024];
                while ((bytes = is.read(bufferOut)) != -1) {
                    os.write(bufferOut, 0, bytes);
                    os.flush();
                }
            } catch (IOException e) {
                log.error("下载视频错误：{}，信息：{}", e, e.getMessage());
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        log.error("下载视频错误：{}，信息：{}", e, e.getMessage());
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        log.error("下载视频错误：{}，信息：{}", e, e.getMessage());
                    }
                }
            }
        }
        return ResponseEntity.ok(Result.successMsg());
    }


}
