package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.MeetingRoom;
import org.springframework.stereotype.Repository;

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
}