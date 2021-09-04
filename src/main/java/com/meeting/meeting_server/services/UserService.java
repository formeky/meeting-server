package com.meeting.meeting_server.services;

import com.meeting.meeting_server.domain.MeetingUsers;
import com.meeting.meeting_server.pojo.query.PageQuery;

import java.util.List;

public interface UserService {
    public MeetingUsers getByOpenId(String openId);

    public MeetingUsers getByUsername(String username);

    public int save(MeetingUsers users);

    public List<MeetingUsers> queryUsers(PageQuery query);

    public MeetingUsers getById(Integer id);

    public int update(MeetingUsers users);

    public void delete(Integer id);
}
