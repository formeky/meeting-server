package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zcw
 */
@RequestMapping("/apply")
@RestController
public class ApplyController {

    @RequestMapping("/list")
    public BaseVo list(){

        return null;
    }

    @RequestMapping("/getByUserId")
    public BaseVo getByUserId(Integer userId, Date date){
        return null;
    }

    @RequestMapping("/deleteById")
    public BaseVo delete(Integer id){
        return null;
    }

    @RequestMapping("/getById")
    public BaseVo getById(Integer id){
        return null;
    }

    @RequestMapping("/update")
    public BaseVo update(MeetingRoom meetingRoom){
        return null;
    }


    @RequestMapping("/addOne")
    public BaseVo addOne(MeetingRoom meetingRoom){
        return null;
    }

}
