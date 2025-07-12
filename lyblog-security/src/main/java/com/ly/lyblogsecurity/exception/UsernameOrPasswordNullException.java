package com.ly.lyblogsecurity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: dly
 * @Date: 2025-07-10-10:26
 * @Description:
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}

