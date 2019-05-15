package cn.shianxian.supervise.common.utils;


/**
 * @Auther: 赵明明
 * @Date: 2018/9/25 14:13
 * @Description: 通用工具类
 */
public class CommonUtils {


    /**
     * 获取文件后缀
     *
     * @param fileName 文件
     * @return
     */
    public static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

}
