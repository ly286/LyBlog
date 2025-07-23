package com.ly.lyblogadmin.service.impl;

import com.ly.lyblogadmin.model.UpdateAdminUserPasswordReqVO;
import com.ly.lyblogadmin.service.AdminUserService;
import com.ly.lyblogcommon.domain.mapper.UserMapper;
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogcommon.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: dly
 * @Date: 2025-07-22-23:25
 * @Description:
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    @Override
    public Result updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        // 拿到用户名、密码
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();

        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        // 更新到数据库
        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Result.success() : Result.failed(ResultCode.USERNAME_NOT_FOUND);
    }
}

