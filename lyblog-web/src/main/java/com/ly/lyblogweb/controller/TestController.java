package com.ly.lyblogweb.controller;

import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogcommon.utils.JsonUtil;
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogweb.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:33
 * @Description:
 */
@Tag(name = "测试", description = "测试相关接口描述")
@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    @Operation(summary = "测试接口", description = "测试接口描述")
    @ApiOperationLog(description = "测试接口")
    public Result<Void> test(@RequestBody @Validated User user) {
//        int i = 1 / 0; // 测试全局异常捕获
        // 获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println(date);
        // 当前日期加一天
        LocalDate tomorrow = date.plusDays(1);
        System.out.println(tomorrow);
        return Result.success();
    }


    @PostMapping("/admin/test2")
    @ApiOperationLog(description = "测试接口")
    @Operation(summary = "测试接口2", description = "测试接口描述2")
    public Result test2(@RequestBody @Validated User user) {
        // 打印入参
        log.info(JsonUtil.toJsonString(user));

        // 设置三种日期字段值
        user.setCreateTime(LocalDateTime.now());
        user.setDate(LocalDate.now());
        user.setTime(LocalTime.now());

        return Result.success(user);
    }

    @PostMapping("/admin/update")
    @ApiOperationLog(description = "测试更新接口")
    @Operation(summary = "测试更新接口", description = "测试更新接口描述")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Result testUpdate() {
        log.info("更新成功...");
        return Result.success();
    }


}
