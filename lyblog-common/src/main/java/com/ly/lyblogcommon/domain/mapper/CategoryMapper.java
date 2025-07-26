package com.ly.lyblogcommon.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.lyblogcommon.domain.dos.CategoryDO;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:29
 * @Description: 
 */
public interface CategoryMapper extends BaseMapper<CategoryDO> {
     // 根据用户名查询
     default CategoryDO selectByName(String categoryName) {
         // 构建查询条件
         LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();
         wrapper.eq(CategoryDO::getName, categoryName);

         // 执行查询
         return selectOne(wrapper);
     }
}
