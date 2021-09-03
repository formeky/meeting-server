package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.MeetingAdmin;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcw
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @RequestMapping("/login")
    public BaseVo login(MeetingAdmin admin){

        return null;
    }
}
