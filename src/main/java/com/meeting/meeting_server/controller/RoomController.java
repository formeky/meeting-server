package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.MeetingRoom;
import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RoomService roomService;

    @RequestMapping("/list")
    public BaseVo list(PageQuery query){

        return new BaseVo(StatusEnum.SUCCESS.getCode(), roomService.queryRoom(query));
    }

    @RequestMapping("/getByUserId")
    public BaseVo getByUserId(Integer userId, Date date){
        return null;
    }

    @RequestMapping("/deleteById")
    public BaseVo delete(Integer id){
        roomService.delete(id);
        return new BaseVo(StatusEnum.SUCCESS.getCode(),"删除成功");
    }

    @RequestMapping("/getById")
    public BaseVo getById(Integer id){
        return new BaseVo(StatusEnum.SUCCESS.getCode(), roomService.getById(id));
    }

    @RequestMapping("/update")
    public BaseVo update(MeetingRoom meetingRoom){
        if (roomService.update(meetingRoom)==1) {
            return new BaseVo(StatusEnum.SUCCESS.getCode(), "更新成功");
        }
        return new BaseVo(StatusEnum.ERROR.getCode(), "失败");
    }


    @RequestMapping("/addOne")
    public BaseVo addOne(MeetingRoom meetingRoom){
        if (roomService.save(meetingRoom) == 1) {
            return new BaseVo(StatusEnum.SUCCESS.getCode(), "添加成功");
        }
        return new BaseVo(StatusEnum.ERROR.getCode(), "添加失败");
    }
}
