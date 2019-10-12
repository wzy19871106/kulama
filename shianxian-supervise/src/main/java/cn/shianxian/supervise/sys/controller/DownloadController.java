package cn.shianxian.supervise.sys.controller;

import cn.shianxian.supervise.common.pojo.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("download")
@Api(description = "下载控制器")
@Slf4j
public class DownloadController {

    /**
     * @param filePath 文件将要保存的目录
     * @param url      请求的路径
     * @return
     */
    @GetMapping("downloadFile")
    @ApiOperation(value = "服务器通用下载接口", notes = "下载到本地")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "url", value = "文件下载的地址"),
            @ApiImplicitParam(paramType = "query", name = "filePath", value = "文件下载到本地的目录地址")
    })
    public ResponseEntity<Result> saveUrlAs(@ApiParam(value = "要下载文件的地址", required = true) String url, String filePath) {
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
//            //以Post方式提交表单，默认get方式
//            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {

                filePath += "/";

            }

            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
            return ResponseEntity.ok(Result.msg("下载失败"));
        }
        return ResponseEntity.ok(Result.data(file));
    }
}
