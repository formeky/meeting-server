package com.meeting.meeting_server.domain;

import lombok.Data;

/**
 * @author zcw
 */
@Data
public class MeetingUsers {
    private Integer id;

    private String userName;

    private String openId;

    private String mobile;

    private String role;

    private String password;

    private Boolean isRegister;
}