package cn.shianxian.supervise.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 截屏取证、反馈 在同一字段picTag中 单独取出的工具类
 */
public class PicTagCutoutUtils {
    public static Map Cutout(String picTag) {
        // 存截图
        List<String> screenshot = new LinkedList<>();
        // 存反馈
        List<String> feedback = new LinkedList<>();
        // 存返回
        Map map = new HashMap();
        if (StringUtils.isNotBlank(picTag)) {
            // 如果有 ， 说明不止一张图片
            if (picTag.indexOf(",") != -1) {
                String[] splits = picTag.split(",");
                if (splits != null && splits.length > 0) {
                    for (String split : splits) {
                        // 判断是否是反馈
                        if (split.indexOf("反馈") != -1) {
                            // 截掉前三个字符  反馈:
                            String substring = split.substring(3);
                            String sub = substring + ",";
                            // String 转 List<String>
                            // List<String> strings = Arrays.asList(sub.split(""));
                            feedback.add(sub);
                        }
                        if (split.indexOf("截屏") != -1) {
                            String substring = split.substring(5);
                            String sub = substring + ",";
                            // String 转 List<String>
                            // List<String> strings = Arrays.asList(sub.split(""));
                            screenshot.add(sub);
                        }
                    }
                }
            } else {
                // 如果 没有， 说明只有一张图片
                if (picTag.indexOf("反馈") != -1) {
                    // 截掉前三个字符  反馈:
                    String substring = picTag.substring(3);
                    String sub = substring + ",";
                    // String 转 List<String>
//                List<String> strings = Arrays.asList(sub.split(""));
                    feedback.add(sub);
                }
                if (picTag.indexOf("截屏") != -1) {
                    String substring = picTag.substring(5);
                    String sub = substring + ",";
                    // String 转 List<String>
                    // List<String> strings = Arrays.asList(sub.split(""));
                    screenshot.add(sub);
                }
            }
        }
        map.put("feedback", feedback);
        map.put("screenshot", screenshot);
        return map;
    }
}
