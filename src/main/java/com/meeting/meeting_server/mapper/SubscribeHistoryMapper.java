package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.SubscribeHistory;
import org.springframework.stereotype.Repository;

/**
 * @author zcw
 */
@Repository
public interface SubscribeHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubscribeHistory record);

    int insertSelective(SubscribeHistory record);

    SubscribeHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubscribeHistory record);

    int updateByPrimaryKey(SubscribeHistory record);
}