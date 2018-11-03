package org.bls.greek.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonTool {
    public static int parseInt(String s, int defaultValue) {
        if (s == null) return defaultValue;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException x) {
            return defaultValue;
        }
    }

    public static long parseLong(String s, long defaultValue) {
        if (s == null) return defaultValue;
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException x) {
            return defaultValue;
        }
    }

    public static Date string2Date(String s, Date defaultValue){
        if (s == null) return defaultValue;
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            return sdf.parse(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String date2String( Date date){
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }

}
