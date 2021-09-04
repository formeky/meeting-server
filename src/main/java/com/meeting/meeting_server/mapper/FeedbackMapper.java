package com.meeting.meeting_server.mapper;

import com.meeting.meeting_server.domain.Feedback;
import com.meeting.meeting_server.pojo.query.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zcw
 */
@Repository
public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> queryFeedback(PageQuery query);
}