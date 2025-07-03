package com.ly.lyblogweb.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:32
 * @Description:
 */
@Data
public class User {
    // 用户名
    @NotNull(message = "用户名不能为空")
    private String username;
    // 性别
    @NotNull(message = "性别不能为空")
    private Integer sex;

    // 年龄
    @NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "年龄不能小于1")
    @Max(value = 200, message = "年龄不能大于200")
    private Integer age;

    // 邮箱
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
