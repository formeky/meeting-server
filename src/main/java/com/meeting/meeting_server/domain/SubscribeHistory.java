package com.meeting.meeting_server.domain;

import lombok.Data;

@Data
public class SubscribeHistory {
    private Integer id;

    private String createTime;

    private Integer roomId;

    private String status;

    private Integer userId;

    private String period;
}