package com.meeting.meeting_server.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author zcw
 */
@Data
public class SubscribeHistory {
    private Integer id;

    private Date createTime;

    private Integer roomId;

    private String status;

    private String userId;

    private Date beginTime;

    private Date endTime;
}