package com.meeting.meeting_server.domain;

import lombok.Data;

/**
 * @author zcw
 */
@Data
public class MeetingRoom {
    private Integer id;

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