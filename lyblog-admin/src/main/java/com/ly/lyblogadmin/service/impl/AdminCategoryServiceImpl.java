package com.ly.lyblogadmin.service.impl;

import com.ly.lyblogadmin.model.vo.category.AddCategoryReqVO;
import com.ly.lyblogadmin.service.AdminCategoryService;
import com.ly.lyblogcommon.domain.dos.CategoryDO;
import com.ly.lyblogcommon.domain.mapper.CategoryMapper;
import com.ly.lyblogcommon.exception.ServiceException;
import com.ly.lyblogcommon.utils.Result;
import com.ly.lyblogcommon.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:49
 * @Description:
 */
@Service
@Slf4j
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加分类
     *
     * @param addCategoryReqVO
     * @return
     */
    @Override
    public Result addCategory(AddCategoryReqVO addCategoryReqVO) {
        String categoryName = addCategoryReqVO.getName();

        // 先判断该分类是否已经存在
        CategoryDO categoryDO = categoryMapper.selectByName(categoryName);

        if (Objects.nonNull(categoryDO)) {
            log.warn("分类名称： {}, 此分类已存在", categoryName);
            throw new ServiceException(ResultCode.CATEGORY_NAME_IS_EXISTED);
        }

        // 构建 DO 类
        CategoryDO insertCategoryDO = CategoryDO.builder()
                .name(addCategoryReqVO.getName().trim())
                .build();

        // 执行 insert
        categoryMapper.insert(insertCategoryDO);

        return Result.success();
    }
}

