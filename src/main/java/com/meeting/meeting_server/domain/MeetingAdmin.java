package com.meeting.meeting_server.domain;

import lombok.Data;

/**
 * @author zcw
 */
@Data
public class MeetingAdmin {
    private Integer id;

    private String userName;

    private String password;
}