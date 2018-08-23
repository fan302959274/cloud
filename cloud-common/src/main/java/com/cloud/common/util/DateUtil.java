/*
 * Copyright (C), 2012-2014, 上海华腾软件系统有限公司
 * FileName: DateUtil.java
 * Author:   justin
 * Date:     2014-7-23 下午7:49:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.cloud.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 常用的日期转换类
 * 
 * @author sunguohua
 */ 
public class DateUtil {
    public static String defaultSimpleFormater = DateUtil.YYYYMMDDHHMMSS;
    public static String defaultSimpleFormater2 = "yyyyMMdd HH:mm:ss";
    public static final String YYMM = "yyyyMM";
    public static final String MMDD = "MM月dd日";
    public static final String YYYYMMDD2 = "yyyy年MM月dd日";

    public static final String DDHHMMSS = "ddHHmmss";

    public static final String YYMMDDHHMMSSSSS = "yyMMddHHmmssSSS";
    
    public static final String YYMMDDHHMMSS = "yyMMddHHmmss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYMMDD = "yyMMdd";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMMDDCOMMON = "yyyy-MM-dd";

    public static final String YYYYMMDDHH = "yyyyMMddHH";
    
    public static final String HHMMSS = "HHmmss";

    /**
     * 默认简单日期字符串
     * 
     * @return
     */
    public static String getDefaultSimpleFormater() {
        return defaultSimpleFormater;
    }

    /**
     * 设置默认简单日期格式字符串
     * 
     * @param defaultFormatString
     */
    public static void setDefaultSimpleFormater(String defaultFormatString) {
        DateUtil.defaultSimpleFormater = defaultFormatString;
    }

    /**
     * 格式化日期
     * 
     * @param date
     * @param formatString
     * @return
     */
    public static String format(Date date, String formatString) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat(formatString);
            return df.format(date);
        }
    }

    /**
     * 格式化日期(使用默认格式)
     * 
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, defaultSimpleFormater);
    }

    /**
     * 转换成日期
     * 
     * @param dateString
     * @param formatString
     * @return
     */
    public static Date parse(String dateString, String formatString) {
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 转换成日期(使用默认格式)
     * 
     * @param dateString
     * @return
     */
    public static Date parse(String dateString) {
        return parse(dateString, defaultSimpleFormater);
    }

    /**
     * 昨天
     * 
     * @return
     */
    public static Date yesterday() {
        return addDay(-1);
    }

    /**
     * 明天
     * 
     * @return
     */
    public static Date tomorrow() {
        return addDay(1);
    }

    /**
     * 现在
     * 
     * @return
     */
    public static Date now() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 按日加
     * 
     * @param value
     * @return
     */
    public static Date addDay(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, value);
        return now.getTime();
    }

    /**
     * 按日加,指定日期
     * 
     * @param date
     * @param value
     * @return
     */
    public static Date addDay(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.DAY_OF_YEAR, value);
        return now.getTime();
    }

    /**
     * 获取本月1日
     * 
     * @return
     */
    public static Date getCureentMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getCurrentDayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();

    }

    public static Date getCurrentDayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();

    }

    /**
     * 获取本月最后一天
     * 
     * @return
     */
    public static Date getCureentMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的1号
     * 
     * @return
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定日期月份的最后一天
     * 
     * @return
     */
    public static Date getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getMonthLastDay2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 按月加
     * 
     * @param value
     * @return
     */
    public static Date addMonth(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, value);
        return now.getTime();
    }

    /**
     * 按月加,指定日期
     * 
     * @param date
     * @param value
     * @return
     */
    public static Date addMonth(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.MONTH, value);
        return now.getTime();
    }

    /**
     * 按年加
     * 
     * @param value
     * @return
     */
    public static Date addYear(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, value);
        return now.getTime();
    }

    /**
     * 按年加,指定日期
     * 
     * @param date
     * @param value
     * @return
     */
    public static Date addYear(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.YEAR, value);
        return now.getTime();
    }

    /**
     * 按小时加
     * 
     * @param value
     * @return
     */
    public static Date addHour(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR_OF_DAY, value);
        return now.getTime();
    }

    /**
     * 按小时加,指定日期
     * 
     * @param date
     * @param value
     * @return
     */
    public static Date addHour(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.HOUR_OF_DAY, value);
        return now.getTime();
    }

    /**
     * 按分钟加
     * 
     * @param value
     * @return
     */
    public static Date addMinute(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, value);
        return now.getTime();
    }

    /**
     * 按分钟加,指定日期
     * 
     * @param date
     * @param value
     * @return
     */
    public static Date addMinute(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.MINUTE, value);
        return now.getTime();
    }

    /**
     * 年份
     * 
     * @return
     */
    public static int year() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR);
    }

    /**
     * 月份
     * 
     * @return
     */
    public static int month() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MONTH);
    }

    /**
     * 日(号)
     * 
     * @return
     */
    public static int day() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 小时(点)
     * 
     * @return
     */
    public static int hour() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.HOUR);
    }

    /**
     * 分钟
     * 
     * @return
     */
    public static int minute() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MINUTE);
    }

    /**
     * 秒
     * 
     * @return
     */
    public static int second() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.SECOND);
    }

    /**
     * 星期几(礼拜几)
     * 
     * @return
     */
    public static int weekday() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 是上午吗?
     * 
     * @return
     */
    public static boolean isAm() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.AM_PM) == 0;
    }

    /**
     * 是下午吗?
     * 
     * @return
     */
    public static boolean isPm() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.AM_PM) == 1;
    }

    public static String getDDHHMMSS() {
        return getDateStr(DDHHMMSS);
    }

    public static String getDateStr(String formatPattern) {
        Date date = new Date();
        return getDateStr(date, formatPattern);
    }

    private static String getDateStr(Date date, String formatPattern) {
        String dateStr = "";
        if (date == null)
            date = new Date();
        try {
            SimpleDateFormat df = new SimpleDateFormat(formatPattern);
            dateStr = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 
     * 字符串转日期对象
     * 
     * @param dateStr 日期字符串
     * @param formatPattern 日期格式
     * @return
     * @see 1.0
     * @since 1.0
     */
    public static Date str2Date(String dateStr, String formatPattern) {
        SimpleDateFormat df = new SimpleDateFormat(formatPattern);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 
     * 日期对象转字符串
     * 
     * @param date 日期对象
     * @param formatPattern 格式
     * @return
     * @see 1.0
     * @since 1.0
     */
    public static String date2Str(Date date, String formatPattern) {
        SimpleDateFormat df = new SimpleDateFormat(formatPattern);
        String dateStr = df.format(date);
        return dateStr;
    }
    

    /**
	 * 获取两个日期相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getDaysBetweenTwoDate(String date1, String date2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);
		return getDaysBetweenTwoDate(format.parse(date1), format.parse(date2));
	}
    
    /**
	 * 获取两个日期相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDaysBetweenTwoDate(Date date1, Date date2) {
		Calendar objCalendarDate1 = Calendar.getInstance();
		objCalendarDate1.setTime(date1);
		Calendar objCalendarDate2 = Calendar.getInstance();
		objCalendarDate2.setTime(date2);
		if (objCalendarDate2.equals(objCalendarDate1)) {
			return 0;
		}
		if (objCalendarDate1.after(objCalendarDate2)) {
			Calendar temp = objCalendarDate1;
			objCalendarDate1 = objCalendarDate2;
			objCalendarDate2 = temp;
		}
		int dayOfYear1 = objCalendarDate1.get(Calendar.DAY_OF_YEAR);
		int dayOfYear2 = objCalendarDate2.get(Calendar.DAY_OF_YEAR);
		if (objCalendarDate1.get(Calendar.YEAR) == objCalendarDate2
				.get(Calendar.YEAR)) {
			return dayOfYear2 - dayOfYear1;
		} else {
			return objCalendarDate1.getActualMaximum(Calendar.DAY_OF_YEAR)
					- dayOfYear1 + dayOfYear2;
		}
	}
	
	/**
	 * 格式化日期 时间
	 * @param date  yyyyMMdd
	 * @param time  HHmmss
	 * @return
	 */
	public static String formatDateAndTime(String date,String time){
		StringBuilder sbStr = new StringBuilder(date+time);
		sbStr.insert(4, "-");
		sbStr.insert(7, "-");
		sbStr.insert(10, " ");
		sbStr.insert(13, ":");
		sbStr.insert(16, ":");
		return sbStr.toString();
	}
    
}