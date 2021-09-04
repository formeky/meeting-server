package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zcw
 */
@RequestMapping("/apply")
@RestController
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @RequestMapping("/getByRoomIdAndDay")
    public BaseVo getByRoomIdAndDay(Integer roomId, Date beginTime,Date endTime){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.getByRoomIdAndDay(roomId, beginTime, endTime));
    }

    @RequestMapping("/addOne")
    public BaseVo addOne(SubscribeHistory subscribeHistory){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.save(subscribeHistory));
    }

    @RequestMapping("/getByUserId")
    public BaseVo getByUserId(Integer roomId,Date beginTime,Date endTime,Integer userId){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.getByUserId(roomId, beginTime, endTime, userId));
    }

    @RequestMapping("/update")
    public BaseVo update(SubscribeHistory subscribeHistory){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.update(subscribeHistory));
    }

    @RequestMapping("/list")
    public BaseVo list(PageQuery query){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.listHistory(query));
    }

    @RequestMapping("/delete")
    public BaseVo delete(Integer id){
        applyService.delete(id);
        return new BaseVo(StatusEnum.SUCCESS.getCode(),"删除成功");
    }

//    @RequestMapping("/getTimes")
//    public BaseVo getTimes(Integer id){
//        return new BaseVo(StatusEnum.SUCCESS.getCode());
//    }


}
