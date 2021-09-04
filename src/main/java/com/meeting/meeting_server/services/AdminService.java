package com.meeting.meeting_server.services;

import com.meeting.meeting_server.domain.MeetingAdmin;

public interface AdminService {
    public MeetingAdmin getAdminByUsername(String username);
}
