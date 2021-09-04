package com.meeting.meeting_server.services;

import com.meeting.meeting_server.domain.Feedback;
import com.meeting.meeting_server.pojo.query.PageQuery;

import java.util.List;

public interface FeedbackService {
    List<Feedback> listFeedback(PageQuery query);

    int insert(Feedback feedback);
}
