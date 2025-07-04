package com.ly.lyblogcommon.exception;

/**
 * @Author: dly
 * @Date: 2025-07-05-0:21
 * @Description:
 */
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogcommon.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result<Void> handleServiceException(ServiceException ex) {
        log.error("业务异常: {}", ex.getMessage(), ex);
        return Result.failed(ex.getResultCode(), ex.getMessage());
    }

    /**
     * 处理JSR303参数校验异常（@Valid）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "参数校验失败";
        log.warn("参数校验失败：{}", msg);
        return Result.failed(ResultCode.VALIDATE_FAILED, msg);
    }

    /**
     * 处理 Spring Validation BindException
     */
    @ExceptionHandler(BindException.class)
    public Result<Void> handleBindException(BindException ex) {
        String msg = ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "参数绑定失败";
        log.warn("参数绑定失败：{}", msg);
        return Result.failed(ResultCode.VALIDATE_FAILED, msg);
    }


    /**
     * 处理缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Void> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.warn("缺少请求参数: {}", ex.getParameterName());
        return Result.failed(ResultCode.VALIDATE_FAILED, "缺少必要参数：" + ex.getParameterName());
    }


    /**
     * 兜底的异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception ex) {
        log.error("系统异常：{}", ex.getMessage(), ex);
        return Result.failed(ResultCode.FAILED, "系统繁忙，请稍后再试");
    }
}