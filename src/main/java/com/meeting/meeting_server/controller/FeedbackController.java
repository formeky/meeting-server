package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.Feedback;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcw
 */
@RequestMapping("/feedback")
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/addOne")
    public BaseVo addOne(Feedback feedback){

        return new BaseVo(StatusEnum.SUCCESS.getCode(), feedbackService.insert(feedback),"添加成功");
    }

    @RequestMapping("/list")
    public BaseVo list(PageQuery query){

        return new BaseVo(StatusEnum.SUCCESS.getCode(), feedbackService.listFeedback(query),"反馈列表");
    }

}
