package com.ly.lyblogweb.controller;

import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogweb.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:33
 * @Description:
 */

@Slf4j
@RestController
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        // 返参
        return user;
    }
}
