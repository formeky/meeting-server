package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.MeetingAdmin;
import com.meeting.meeting_server.mapper.MeetingAdminMapper;
import com.meeting.meeting_server.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private MeetingAdminMapper adminMapper;

    @Override
    public MeetingAdmin getAdmin(MeetingAdmin admin) {
        return adminMapper.selectByPrimaryKey(hashCode());
    }
}
