package com.ly.lyblogadmin.controller;

import com.ly.lyblogadmin.model.vo.category.AddCategoryReqVO;
import com.ly.lyblogadmin.service.AdminCategoryService;
import com.ly.lyblogcommon.aspect.ApiOperationLog;
import com.ly.lyblogcommon.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:55
 * @Description:
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "Admin分类模块")
public class AdminCategoryController {
    @Autowired
    private AdminCategoryService adminCategoryService;

    @PostMapping("/category/add")
    @ApiOperationLog(description = "添加分类")
    public Result addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return adminCategoryService.addCategory(addCategoryReqVO);
    }
}
