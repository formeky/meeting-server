package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zcw
 */
@RequestMapping("/room")
@RestController
public class RoomController {


    @RequestMapping("/getByRoomIdAndDay")
    public BaseVo getByRoomIdAndDay(Integer roomId, String day){
        return null;
    }

    @RequestMapping("/addOne")
    public BaseVo addOne(SubscribeHistory subscribeHistory){
        return null;
    }

    @RequestMapping("/getByUserId")
    public BaseVo getByUserId(Integer roomId,Date date,Integer userId){
        return null;
    }

    @RequestMapping("/update")
    public BaseVo update(SubscribeHistory subscribeHistory){
        return null;
    }

    @RequestMapping("/list")
    public BaseVo list(){
        return null;
    }

    @RequestMapping("/delete")
    public BaseVo delete(Integer id){
        return null;
    }

    @RequestMapping("/getTimes")
    public BaseVo getTimes(Integer id){
        return null;
    }
}
