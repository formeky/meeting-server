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

    private MeetingRoom meetingRoom;

    private String name;

    private Integer maxNum;

    private String subscribeHistoryIds;

    private String applictionId;

    private String applictionSecrit;

    private String productId;

    private String deviceId;

    private Integer msgId;

    private String ablity;

    private String service;

    private String address;
}