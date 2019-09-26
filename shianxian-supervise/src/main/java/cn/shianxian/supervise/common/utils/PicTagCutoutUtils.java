package cn.shianxian.supervise.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 截屏取证、反馈 在同一字段picTag中 单独取出的工具类
 */
public class PicTagCutoutUtils {
    public static Map Cutout(String picTag) {
        // 存截图
//        List<String> screenshot = new LinkedList<>();
        StringBuilder screenshot = new StringBuilder();
        // 存反馈
//        List<String> feedback = new LinkedList<>();
        StringBuilder feedback = new StringBuilder();
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
                            feedback.append(sub);
                        }
                        if (split.indexOf("截屏") != -1) {
                            String substring = split.substring(5);
                            String sub = substring + ",";
                            // String 转 List<String>
                            // List<String> strings = Arrays.asList(sub.split(""));
                            screenshot.append(sub);
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
                    feedback.append(sub);
                }
                if (picTag.indexOf("截屏") != -1) {
                    String substring = picTag.substring(5);
                    String sub = substring + ",";
                    // String 转 List<String>
                    // List<String> strings = Arrays.asList(sub.split(""));
                    screenshot.append(sub);
                }
            }
        }
        if (StringUtils.isNotBlank(feedback.toString())){
            String substring = feedback.toString().substring(0, feedback.toString().length() - 1);
            map.put("feedback", substring);
        }
        if (StringUtils.isNotBlank(screenshot.toString())){
            String substring = screenshot.toString().substring(0, screenshot.toString().length() - 1);
            map.put("screenshot", substring);
        }
        return map;
    }
}
