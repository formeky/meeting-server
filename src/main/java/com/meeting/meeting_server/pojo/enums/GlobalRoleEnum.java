package com.meeting.meeting_server.pojo.enums;

/**
 * @author zcw
 * @date 2021/7/19
 */
public enum GlobalRoleEnum {
    /**
     *游客
     */
    tourist(0),
    /**
     * 内容管理员
     */
    contentManager(1),
    /**
     * 系统管理员
     */
    admin(2);
    private int code;

    GlobalRoleEnum(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }

    public static GlobalRoleEnum valueOf(int code) {
        switch(code) {
            case 0:
                return tourist;
            case 1:
                return contentManager;
            case 2:
                return admin;
            default:
                throw new IllegalArgumentException("argument out of range");
        }
    }
}
