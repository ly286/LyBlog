package com.ly.lyblogweb.controller;

import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogweb.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "测试", description = "测试相关接口描述")
@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    @Operation(summary = "测试接口", description = "测试接口描述")
    @ApiOperationLog(description = "测试接口")
    public Result<Void> test(@RequestBody @Validated User user) {
//        int i = 1 / 0; // 测试全局异常捕获
        return Result.success();
    }

}
