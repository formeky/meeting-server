package com.meeting.meeting_server.domain;

import lombok.Data;

/**
 * @author zcw
 */
@Data
public class Feedback {
    private Integer id;

    private String content;

    private String contact;

    private Integer userId;
}