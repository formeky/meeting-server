package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.SubscribeHistory;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.ApplyService;
import com.meeting.meeting_server.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

/**
 * @author zcw
 */
@RequestMapping("/apply")
@RestController
public class ApplyController {

    @Autowired
    private ApplyService applyService;

//    @RequestMapping("/getByRoomIdAndDay")
//    public BaseVo getByRoomIdAndDay(Integer roomId, Date beginTime,Date endTime){
//        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.getByRoomIdAndDay(roomId, beginTime, endTime));
//    }

    @PostMapping("/getOneDay")
    public BaseVo getOneDay(Integer userId, Integer year,String createTime) throws ParseException {

        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.getOneDay(userId, year+"年"+createTime));
    }

    @PostMapping("/addOne")
    public BaseVo addOne(Integer roomId,Integer userId,String status,String createTime,String subscribeTime,Integer year) throws ParseException {
        SubscribeHistory subscribeHistory = new SubscribeHistory();
        subscribeHistory.setRoomId(roomId);
        subscribeHistory.setUserId(userId);
        subscribeHistory.setStatus(status);
        subscribeHistory.setCreateTime(year+"年"+createTime);
        subscribeHistory.setPeriod(subscribeTime);
        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.save(subscribeHistory));
    }

    @RequestMapping("/getByUserId")
    public BaseVo getByUserId(Integer userId){

        return new BaseVo(StatusEnum.SUCCESS.getCode(),applyService.getByUserId(userId));
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
