package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.pojo.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcw
 */
@RequestMapping("/feedback")
@RestController
public class FeedbackController {

    @RequestMapping("/addOne")
    public BaseVo addOne(){

        return null;
    }

    @RequestMapping("/list")
    public BaseVo list(){

        return null;
    }

}
