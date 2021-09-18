package com.meeting.meeting_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MeetingServerApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        String t = "2010-12-31 23:59:59";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date = dateFormat.parse(t);
        System.out.println(date);
    }

}
