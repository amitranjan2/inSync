package com.codingstreams.jwtauth.utill;
import com.codingstreams.jwtauth.enums.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
    public static String customDateFormatter(Date date, DateFormat format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getPattern());
        return sdf.format(date);
    }
}




