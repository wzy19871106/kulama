package cn.shianxian.supervise.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 日期Util类
 */
@Slf4j
public class DateUtils {


    private static final DateTimeFormatter yyyyMMddHHmmssFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter yyyyMMddFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final ZoneId zoneId = ZoneOffset.systemDefault();


    /**
     * 获取时间戳
     */
    public static long getTimestamp() {
        return LocalDateTime.now().atZone(zoneId).toEpochSecond();
    }


    /**
     * 获取时间字符串
     *
     * @param date
     * @return
     */
    public static String yyyyMMddHHmmssFormat(LocalDateTime date) {
        return yyyyMMddHHmmssFormat.format(date);
    }


    /**
     * 获取时间字符串
     *
     * @return
     */
    public static LocalDateTime yyyyMMddHHmmssParse(String date) {
        return LocalDateTime.parse(date, yyyyMMddHHmmssFormat);
    }


    /**
     * 获取时间字符串
     *
     * @param date
     * @return
     */
    public static String yyyyMMddFormat(LocalDate date) {
        return yyyyMMddFormat.format(date);
    }


   /**
     * 获取时间字符串
     *
     * @param date
     * @return
     */
    public static LocalDate yyyyMMddParse(String date) {
        return LocalDate.parse(date, yyyyMMddFormat);
    }


    /**
     * 获取两个月份之差（支持跨年）
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static int getMonthNum(LocalDateTime startTime, LocalDateTime endTime) {
        return getMonthNum(0, startTime, endTime);
    }


    /**
     * 递归算出两个月份之差（支持跨年）
     * @param i
     * @param startTime
     * @param endTime
     * @return
     */
    private static int getMonthNum(int i, LocalDateTime startTime, LocalDateTime endTime) {
        LocalDateTime temp = startTime.plusMonths(1);
        if (temp.getYear() < endTime.getYear() || (temp.getYear() == endTime.getYear() && temp.getMonthValue() <= endTime.getMonthValue())) {
            i++;
            return getMonthNum(i, temp, endTime);
        }
        return i;
    }
}
