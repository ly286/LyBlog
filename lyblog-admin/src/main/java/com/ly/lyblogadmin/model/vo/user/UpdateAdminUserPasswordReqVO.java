package com.ly.lyblogadmin.model.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

/**
 * @Author: dly
 * @Date: 2025-07-22-22:39
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "修改用户密码 VO")
public class UpdateAdminUserPasswordReqVO {

    @NotNull(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String username;

    @NotNull(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;
}
