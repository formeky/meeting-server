package com.meeting.meeting_server.pojo.vo;

import com.meeting.meeting_server.pojo.enums.StatusEnum;
import lombok.Data;


/**
 * @author zcw
 * @date 2020/10/6
 * @description:
 */
@Data
public class BaseVo<T> {
    private Integer code;
    private T data;
    private String msg;

    public BaseVo() {
        this.code= StatusEnum.SUCCESS.code;
        this.msg = "SUCCESS";
    }

    public BaseVo(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public BaseVo(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public BaseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
