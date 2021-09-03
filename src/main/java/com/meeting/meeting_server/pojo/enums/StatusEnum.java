package com.meeting.meeting_server.pojo.enums;

/**
 * @author zcw
 * @date 2021.07.19
 */
public enum StatusEnum{
    /**
     * 正常
     */
    SUCCESS(200),

    /**
     * 参数错误
     */
    PARAM_ERROR(400),
    /**
     * 未登录
     */
    UN_LOGIN(401),
    /**
     * token错误
     */
    TOKEN_ERROR(402),
    /**
     * 禁止访问
     */
    FORBIDDEN(403),
    /**
     * 弱密码
     */
    PASSWORD_IS_NOT_STRONG(404),
    /**
     * 用户已存在
     */
    USERNAME_EXISTED(405),
    /**
     * 邮箱已存在
     */
    EMAIL_EXISTED(405),
    /**
     * 邮箱错误
     */
    MAIL_ERROR(406),
    /**
     * 密码错误
     */
    PASSWORD_WRONG(407),
    /**
     * 文件大小错误
     */
    FILE_SIZE_ERROR(408),
    /**
     * 错误
     */
    ERROR(500),
    /**
     * 文件保存错误
     */
    FILE_SAVE_ERROR(500)
    ;

    public Integer code;

    StatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    public static StatusEnum valueOf(int code) {
        for (StatusEnum value : StatusEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("argument out of range");
    }
}
