package com.ly.lyblogweb.controller;

import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogweb.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:33
 * @Description:
 */

@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Result<Void> test(@RequestBody @Validated User user) {
        int i = 1 / 0; // 测试全局异常捕获
        return Result.success();
    }

}
