package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.mapper.MeetingRoomMapper;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    @Override
    public int save(MeetingRoom meetingRoom) {
        return meetingRoomMapper.insert(meetingRoom);
    }

    @Override
    public int update(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateByPrimaryKeySelective(meetingRoom);
    }

    @Override
    public MeetingRoom getById(Integer id) {
        return meetingRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Integer id) {
        meetingRoomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MeetingRoom> queryRoom(PageQuery query) {
        return meetingRoomMapper.queryRoom(query);
    }

    @Override
    public List<MeetingRoom> getByUserId(Integer userId, Date date) {
        return null;
    }
}
