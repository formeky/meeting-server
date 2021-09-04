package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.MeetingUsers;
import com.meeting.meeting_server.pojo.query.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    MeetingUsers getByOpenId(String openId);

    List<MeetingUsers> queryUsers(PageQuery query);

    MeetingUsers getByUsername(String username);
}