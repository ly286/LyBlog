package com.ly.lyblogadmin.controller;

import com.ly.lyblogadmin.model.vo.tag.AddTagReqVO;
import com.ly.lyblogadmin.service.AdminCategoryService;
import com.ly.lyblogadmin.service.AdminTagService;
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
 * @Date: 2025-07-26-22:55
 * @Description: 标签
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "Admin标签模块")
public class AdminTagController {
    @Autowired
    private AdminTagService adminTagService;

    @Autowired
    private AdminCategoryService categoryService;

    @PostMapping("/tag/add")
    @Operation(summary = "添加标签", description = "添加标签描述")
    @ApiOperationLog(description = "添加标签")
    public Result addTag(@RequestBody @Validated AddTagReqVO addTagReqVO) {
        return adminTagService.addTag(addTagReqVO);
    }

//    @PostMapping("/category/list")
//    @Operation(summary = "分类分页数据获取", description = "分类分页数据获取描述")
//    @ApiOperationLog(description = "分类分页数据获取")
//    public PageResult findCategoryList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
//        return categoryService.findCategoryList(findCategoryPageListReqVO);
//    }
//
//    @PostMapping("/category/delete")
//    @Operation(summary = "删除分类", description = "删除分类描述")
//    @ApiOperationLog(description = "删除分类")
//    public Result deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
//        return categoryService.deleteCategory(deleteCategoryReqVO);
//    }
//
//    @PostMapping("/category/select/list")
//    @Operation(summary = "分类 Select 下拉列表数据获取", description = "分类 Select 下拉列表数据获取描述")
//    @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
//    public Result<List<SelectRspVO>> findCategorySelectList() {
//        return categoryService.findCategorySelectList();
//    }


}
