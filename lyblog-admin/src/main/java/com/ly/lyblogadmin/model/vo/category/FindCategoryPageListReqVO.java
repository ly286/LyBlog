package com.ly.lyblogadmin.model.vo.category;

import com.ly.lyblogcommon.model.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: dly
 * @Date: 2025-07-27-21:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "查询分类分页列表请求体")
public class FindCategoryPageListReqVO extends BasePageQuery {

    /**
     * 分类名称
     */
    private String name;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;

}
