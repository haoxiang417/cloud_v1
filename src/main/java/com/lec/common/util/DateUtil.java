package com.lec.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhouhaij on 2016/12/6.
 */
public class DateUtil extends com.lec.framework.util.DateUtil {

    private DateUtil() {

    }

    /***
     * 获取一周的第一天
     * @param date
     * @return
     */
    public static Date getBeginOfWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int dayOfWeek = ca.get(7);
        ca.add(5, -((dayOfWeek + 5) % 7));
        return (Date) ca.getTime().clone();
    }

    /***
     * 获取一周的最后一天
     * @param date
     * @return
     */
    public static Date getEndOfWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_WEEK, ca.getActualMaximum(Calendar.DAY_OF_WEEK));

        Date last = (Date) ca.getTime().clone();
        ca.setTime(last);
        int day = ca.get(Calendar.DAY_OF_YEAR);
        ca.set(Calendar.DAY_OF_YEAR, day + 1);
        return getEndOfDay(ca.getTime());
    }
    
    /***
     * 获取一月的第一天
     * @param date
     * @return
     */
    public static Date getBeginOfMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DATE, 1);
        return (Date) ca.getTime().clone();
    }

    /***
     * 获取一月的最后一天
     * @param date
     * @return
     */
    public static Date getEndOfMonth(Date date) {
    	Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DATE, 1);
        ca.add(Calendar.DATE, -1);
        return (Date) ca.getTime().clone();
    }

}
