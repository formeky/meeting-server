package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.pojo.query.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author zcw
 */
@Repository
public interface MeetingRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);

    List<MeetingRoom> queryRoom(PageQuery query);

    List<MeetingRoom> getByUserId(Integer userId, Date date);
}