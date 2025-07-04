package com.ly.lyblogcommon.exception;

import com.ly.lyblogcommon.utils.ResultCode;
import lombok.Getter;

/**
 * @Author: dly
 * @Date: 2025-07-05-0:24
 * @Description:
 */
@Getter
public class ServiceException extends RuntimeException {
    private final ResultCode resultCode;

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

}
