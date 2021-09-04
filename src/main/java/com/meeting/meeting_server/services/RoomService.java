package com.meeting.meeting_server.services;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.pojo.query.PageQuery;

import java.util.Date;
import java.util.List;

public interface RoomService {

    public int save(MeetingRoom meetingRoom);

    public int update(MeetingRoom meetingRoom);

    public MeetingRoom getById(Integer id);

    public void delete(Integer id);

    public List<MeetingRoom> queryRoom(PageQuery query);

    public List<MeetingRoom> getByUserId(Integer userId, Date date);
}
