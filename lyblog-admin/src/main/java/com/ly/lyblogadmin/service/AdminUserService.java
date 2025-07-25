package com.ly.lyblogadmin.service;

import com.ly.lyblogadmin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.ly.lyblogcommon.utils.Result;

/**
 * @Author: dly
 * @Date: 2025-07-22-23:25
 * @Description:
 */
public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Result updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Result findUserInfo();
}

