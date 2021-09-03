package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.MeetingAdmin;
import org.springframework.stereotype.Repository;

/**
 * @author zcw
 */
@Repository
public interface MeetingAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingAdmin record);

    int insertSelective(MeetingAdmin record);

    MeetingAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingAdmin record);

    int updateByPrimaryKey(MeetingAdmin record);
}