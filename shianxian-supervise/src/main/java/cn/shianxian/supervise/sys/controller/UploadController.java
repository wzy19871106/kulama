package cn.shianxian.supervise.sys.controller;


import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.utils.CommonUtils;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @Auther: 赵明明
 * @Date: 2018/9/25 16:11
 * @Description: 通用上传类
 */
@RestController
@RequestMapping("upload")
@Slf4j
@Api(description = "通用上传控制器")
public class UploadController {


    @Value("${upload.path}")
    private String uploadPath;

    @Value("${upload.url}")
    private String uploadUrl;


    private String fileType = ".jpg.bmp.jpeg.png.gif.JPG.BMP.JPEG.PNG.GIF";


    /**
     * 服务器上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("img")
    @ApiOperation(value = "服务器通用上传接口", notes = "上传到服务器")
    @ApiImplicitParam(paramType = "query", name = "key", value = "文件名，可传可不传，如果文件名在服务器存在会删除该文件，然后存储。请带上后缀名。")
    public ResponseEntity<Result> uploadImg(@ApiParam(value = "要上传的文件", required = true) MultipartFile file, @RequestParam(value = "key", required = false) String key) throws IOException {
        String fileSuffix = CommonUtils.getFileSuffix(file.getOriginalFilename());
        if (!fileType.contains(fileSuffix)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.msg("请上传图片！"));
        }
        String fileName = UUIDGenerator.generatorUUID();
        // 如果是修改图片，先把之前的图片删除
        if (StringUtils.isNotEmpty(key)) {
            // 删除临时文件
            File oldFile = new File( uploadPath + key);
            if (oldFile.exists()) {
                oldFile.delete();
            }
            fileName = key.substring(0, key.lastIndexOf("."));
        }
        File f = new File(uploadPath);
        if (!f.exists()) {
            f.mkdirs();
            log.info("创建文件夹：{}", uploadPath);
        }
        fileName = fileName + fileSuffix;
        String filepath = uploadPath + fileName;
        File tmpFile = new File(filepath);
        file.transferTo(tmpFile);
        log.info("上传文件成功：{}", fileName);
        return ResponseEntity.ok(Result.data(uploadUrl + fileName));
    }

}
