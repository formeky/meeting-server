package com.meeting.meeting_server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meeting.meeting_server.domain.MeetingUsers;
import com.meeting.meeting_server.pojo.enums.StatusEnum;
import com.meeting.meeting_server.pojo.query.PageQuery;
import com.meeting.meeting_server.pojo.vo.BaseVo;
import com.meeting.meeting_server.services.UserService;
import com.meeting.meeting_server.utils.ImportExcel;
import com.meeting.meeting_server.utils.Md5Util;
import com.meeting.meeting_server.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getByOpenId")
    public BaseVo getByOpenId(String openId) {
        return new BaseVo(StatusEnum.SUCCESS.getCode(), userService.getByOpenId(openId));
    }

    @RequestMapping("/insert")
    public BaseVo insert(MeetingUsers meetingUsers) {
        if (userService.getByUsername(meetingUsers.getUserName())!=null) {
            return new BaseVo(StatusEnum.EMAIL_EXISTED.getCode(),"用户已存在");
        }
        if (userService.save(meetingUsers)==1){
            return new BaseVo(StatusEnum.SUCCESS.getCode(), "添加成功");
        }
        return new BaseVo(StatusEnum.ERROR.getCode(), "添加失败");
    }

    @GetMapping("/getAll")
    public BaseVo list(PageQuery query) {
        return new BaseVo(StatusEnum.SUCCESS.getCode(),userService.queryUsers(query), "添加成功");
    }

    @GetMapping("/getById")
    public BaseVo getById(Integer id) {
        return new BaseVo(StatusEnum.SUCCESS.getCode(), userService.getById(id));
    }

    @RequestMapping("/wxLogin")
    public BaseVo wxLogin(String username, String password) {
        MeetingUsers meetingUser = userService.getByUsername(username);
        if (meetingUser==null){
            return new BaseVo(StatusEnum.ERROR.getCode(), "无此用户");
        }
        if (password.equals(meetingUser.getPassword())) {
            return new BaseVo(StatusEnum.SUCCESS.getCode(), meetingUser);
        }
        return new BaseVo(StatusEnum.PASSWORD_WRONG.getCode(), "密码错误");
    }

    @RequestMapping("/login")
    public MeetingUsers doLogin(String code, String rawData, String signature, String encrypteData, String iv) {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject rawDataJson = JSON.parseObject(rawData);
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId(code);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");
        //User user = userService.findByOpenid( openid );
        MeetingUsers meetingUsers = userService.getByOpenId(openid);
        if (meetingUsers == null) {
            meetingUsers = new MeetingUsers();
            meetingUsers.setOpenId(openid);
            return meetingUsers;
        } else {
            return meetingUsers;
        }
        //uuid生成唯一key
        //String skey = UUID.randomUUID().toString();
        //return null;
    }

    @RequestMapping("/update")
    public BaseVo update(MeetingUsers meetingUsers) {
        if (userService.update(meetingUsers)==1) {
            return new BaseVo(StatusEnum.SUCCESS.getCode(), "修改成功");
        }
        return new BaseVo(StatusEnum.ERROR.getCode(), "失败");
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id) {
        userService.delete(id);
    }

//    @RequestMapping("/register")
//    public Object register(String userName){
//        return meetingUsersService.register(userName);
//    }

    @RequestMapping("/modifyPassword")
    public BaseVo modifyPassword(MeetingUsers users){
        if (userService.update(users) ==1) {
            return new BaseVo(StatusEnum.SUCCESS.getCode(), "成功");
        }
        return new BaseVo(StatusEnum.ERROR.getCode(), "失败");
    }

    public static JSONObject getSessionKeyOrOpenId(String code) {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", "wxf6893f6fe1eb7d91");//小程序appId
        requestUrlParam.put("secret", "3f70eed732b6f9aa698ac09f04c49e26");
        requestUrlParam.put("js_code", wxCode);//小程序端返回的code
        requestUrlParam.put("grant_type", "authorization_code");//默认参数

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(Request.sendPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

    @RequestMapping("/uploadExcel")
    public String uploadExcel(@RequestParam("file") MultipartFile multfile) {
        String path = "";
        Map<String,Object> maps = new HashMap<String,Object>();
        Map<String,Object> maps2 = new HashMap<String,Object>();
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        try{


            final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
            // 将MultipartFile转为File

            multfile.transferTo(excelFile);

            System.out.println("contextLoads--》》测试成功");
            ImportExcel excel = new ImportExcel();
            List<MeetingUsers> newStudents = new ArrayList<MeetingUsers>();

            newStudents = excel.importXLS(excelFile.toString());
            // 程序结束时，删除临时文件
            deleteFile(excelFile);
            System.out.println(newStudents.size());
            for (int i = 0; i < newStudents.size(); i++) {
                userService.save(newStudents.get(i));
            }
        }catch (Exception e){
            System.out.println("文件格式出错");
            return "文件格式出错";
        }
        return "success";
    }

    /**
     * 删除临时文件
     *
     * @param
     */
    private void deleteFile(File path) {
        if (null != path) {
            if (!path.exists()) {
                return;
            }
            if (path.isFile()) {
                boolean result = path.delete();
                int tryCount = 0;
                while (!result && tryCount++ < 10) {
                    System.gc(); // 回收资源
                    result = path.delete();
                }
            }
            File[] files = path.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            path.delete();
        }
    }
}
