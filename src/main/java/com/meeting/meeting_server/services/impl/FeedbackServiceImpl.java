package com.meeting.meeting_server.services.impl;

import com.meeting.meeting_server.domain.Feedback;
import com.meeting.meeting_server.mapper.FeedbackMapper;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> listFeedback(PageQuery query) {
        return feedbackMapper.queryFeedback(query);
    }

    @Override
    public int insert(Feedback feedback) {
        return feedbackMapper.insert(feedback);
    }
}
