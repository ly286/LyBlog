package com.ly.lyblogadmin.service;

import com.ly.lyblogadmin.model.vo.category.AddCategoryReqVO;
import com.ly.lyblogadmin.model.vo.category.DeleteCategoryReqVO;
import com.ly.lyblogadmin.model.vo.category.FindCategoryPageListReqVO;
import com.ly.lyblogcommon.model.vo.SelectRspVO;
import com.ly.lyblogcommon.utils.PageResult;
import com.ly.lyblogcommon.utils.Result;

import java.util.List;

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

    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Result deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);

    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Result<List<SelectRspVO>> findCategorySelectList();
}
