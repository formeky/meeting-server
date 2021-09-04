package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.MeetingUsers;
import com.meeting.meeting_server.mapper.MeetingUsersMapper;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MeetingUsersMapper meetingUsersMapper;

    @Override
    public MeetingUsers getByOpenId(String openId) {
        return meetingUsersMapper.getByOpenId(openId);
    }

    @Override
    public MeetingUsers getByUsername(String username) {
        return meetingUsersMapper.getByUsername(username);
    }

    @Override
    public int save(MeetingUsers users) {
        return meetingUsersMapper.insert(users);
    }

    @Override
    public List<MeetingUsers> queryUsers(PageQuery query) {
        return meetingUsersMapper.queryUsers(query);
    }

    @Override
    public MeetingUsers getById(Integer id) {
        return meetingUsersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(MeetingUsers users) {
        return meetingUsersMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public void delete(Integer id) {
        meetingUsersMapper.deleteByPrimaryKey(id);
    }
}
