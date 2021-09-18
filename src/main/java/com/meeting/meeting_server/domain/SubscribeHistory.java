package com.meeting.meeting_server.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
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

    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}