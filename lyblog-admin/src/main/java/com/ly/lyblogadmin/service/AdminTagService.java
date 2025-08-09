package com.ly.lyblogadmin.service;

import com.ly.lyblogadmin.model.vo.tag.AddTagReqVO;
import com.ly.lyblogcommon.utils.Result;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:48
 * @Description:
 */
public interface AdminTagService {

    Result addTag(AddTagReqVO addTagReqVO);
}
