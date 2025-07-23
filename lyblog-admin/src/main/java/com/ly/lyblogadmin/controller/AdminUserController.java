package com.ly.lyblogadmin.controller;

import com.ly.lyblogadmin.model.UpdateAdminUserPasswordReqVO;
import com.ly.lyblogadmin.service.AdminUserService;
import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogcommon.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dly
 * @Date: 2025-07-22-23:30
 * @Description:
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "Admin 用户模块")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @PostMapping("/password/update")
    @Operation(summary = "修改用户密码", description = "修改用户密码描述")
    @ApiOperationLog(description = "修改用户密码")
    public Result updatePassword(@RequestBody @Validated UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        return userService.updatePassword(updateAdminUserPasswordReqVO);
    }
}

