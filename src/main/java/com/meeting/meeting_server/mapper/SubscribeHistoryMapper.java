package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.query.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    List<SubscribeHistory> listHistory(PageQuery query);

    List<SubscribeHistory> getByRoomIdAndDay(Integer roomId, Date beginTime, Date endTime);

    List<SubscribeHistory> getByUserId(Integer roomId, Date beginTime, Date endTime, Integer userId);
}