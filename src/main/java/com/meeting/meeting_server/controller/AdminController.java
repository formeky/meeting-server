package com.meeting.meeting_server.controller;

import com.meeting.meeting_server.domain.MeetingAdmin;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.AdminService;
import com.meeting.meeting_server.utils.Md5Util;
import com.meeting.meeting_server.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcw
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public BaseVo login(MeetingAdmin admin){
        MeetingAdmin adminByUsername = adminService.getAdminByUsername(admin.getUserName());
        if (adminByUsername==null){
            return new BaseVo(StatusEnum.ERROR.getCode(), "无此用户");
        }
        if (Md5Util.StringInMd5(admin.getPassword()).equals(adminByUsername.getPassword())){
            return new BaseVo(StatusEnum.SUCCESS.getCode(), TokenUtil.getToken(admin.getUserName()),"登陆成功");
        }else{
            return new BaseVo(StatusEnum.PASSWORD_WRONG.getCode(), "登陆失败");
        }
    }
}
