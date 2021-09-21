package com.meeting.meeting_server.services;

import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.query.PageQuery;

import java.util.Date;
import java.util.List;

public interface ApplyService {
    public List<SubscribeHistory> getByRoomIdAndDay(Integer roomId, Date beginTime,Date endTime);

    public List<SubscribeHistory> getOneDay(Integer userId, String createTime);

    public int save(SubscribeHistory subscribeHistory);

    public List<SubscribeHistory> getByUserId(Integer userId);

    public int update(SubscribeHistory subscribeHistory);

    public List<SubscribeHistory> listHistory(PageQuery query);

    public void delete(Integer id);
}
