package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.MeetingAdmin;
import com.meeting.meeting_server.mapper.MeetingAdminMapper;
import com.meeting.meeting_server.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private MeetingAdminMapper adminMapper;

    @Override
    public MeetingAdmin getAdminByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }
}
