package com.ly.lyblogcommon.utils;

import lombok.Getter;

/**
 * @Author: dly
 * @Date: 2025-07-03-23:59
 * @Description:
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    LOGIN_FAIL(20000, "登录失败"),
    USERNAME_OR_PWD_ERROR(20001, "用户名或密码错误");


    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
