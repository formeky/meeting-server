package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.mapper.SubscribeHistoryMapper;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.services.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private SubscribeHistoryMapper subscribeHistoryMapper;

    @Override
    public List<SubscribeHistory> getByRoomIdAndDay(Integer roomId, Date beginTime, Date endTime) {
        return null;
    }

    @Override
    public List<SubscribeHistory> getOneDay(Integer userId, String createTime) {
        return subscribeHistoryMapper.getOneDay(userId, createTime);
    }

    @Override
    public int save(SubscribeHistory subscribeHistory) {
        return subscribeHistoryMapper.insertSelective(subscribeHistory);
    }

    @Override
    public List<SubscribeHistory> getByUserId(Integer userId) {
        return subscribeHistoryMapper.getByUserId(userId);
    }

    @Override
    public int update(SubscribeHistory subscribeHistory) {
        return subscribeHistoryMapper.updateByPrimaryKey(subscribeHistory);
    }

    @Override
    public List<SubscribeHistory> listHistory(PageQuery query) {
        return null;
    }


    @Override
    public void delete(Integer id) {
        subscribeHistoryMapper.deleteByPrimaryKey(id);
    }
}
