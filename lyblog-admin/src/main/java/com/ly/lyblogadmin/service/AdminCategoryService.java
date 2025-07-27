package com.ly.lyblogadmin.service;

import com.ly.lyblogadmin.model.vo.category.FindCategoryPageListReqVO;
import com.ly.lyblogadmin.model.vo.category.AddCategoryReqVO;
import com.ly.lyblogcommon.utils.PageResult;
import com.ly.lyblogcommon.utils.Result;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:48
 * @Description:
 */
public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Result addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResult findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);
}
