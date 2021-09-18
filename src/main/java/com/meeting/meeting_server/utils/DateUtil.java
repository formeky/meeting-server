package com.meeting.meeting_server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getDateFromParam(Integer year,String createDay,String time) throws ParseException {
        String d = String.valueOf(year)+" "+createDay+" "+time;
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM月dd日 hh:mm");
        Date date = df.parse(d);
        return date;
    }
}
