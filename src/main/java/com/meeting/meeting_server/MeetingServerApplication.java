package com.meeting.meeting_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zcw
 */
@MapperScan("com.meeting.meeting_server.mapper")
@SpringBootApplication
public class MeetingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingServerApplication.class, args);
    }

}
