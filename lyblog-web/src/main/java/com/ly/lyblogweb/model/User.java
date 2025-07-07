package com.ly.lyblogweb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:32
 * @Description:
 */
@Data
@Schema(description = "用户信息")
public class User {
    // 用户名
    @Schema(description = "用户名",example = "张三")
    @NotNull(message = "用户名不能为空")
    private String username;
    // 性别
    @Schema(description = "性别",example = "1")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    // 年龄
    @Schema(description = "年龄",example = "18")
    @NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "年龄不能小于1")
    @Max(value = 200, message = "年龄不能大于200")
    private Integer age;

    // 邮箱
    @Schema(description = "邮箱",example = "123456@qq.com")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    //日期
    private LocalDate Date;

    // 时间
    private LocalTime time;
}
