package cn.shianxian.supervise.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Date: 2019/3/14 16:10
 * @Description: base64工具类
 */
public class Base64Utils {


    // base64字符串转化成图片
    public static File GenerateImage(String imgStr, String path) throws IOException {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            // 图像数据为空
            return null;
        }
        // 获取后缀
        String suffix = imgStr.substring(11, imgStr.lastIndexOf(";"));
        String fileName = UUIDGenerator.generatorUUID();
        String imgFilePath = path + fileName + "." + suffix;//新生成的图片
        // 获取图片base64
        String img = imgStr.substring(imgStr.lastIndexOf(",") + 1);
        // Base64解码
        byte[] bytes = Base64.decodeBase64(img);
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(bytes);
        out.flush();
        out.close();
        return new File(imgFilePath);
    }


}
