package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.MeetingUsers;
import org.springframework.stereotype.Repository;

/**
 * @author zcw
 */
@Repository
public interface MeetingUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingUsers record);

    int insertSelective(MeetingUsers record);

    MeetingUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingUsers record);

    int updateByPrimaryKey(MeetingUsers record);
}