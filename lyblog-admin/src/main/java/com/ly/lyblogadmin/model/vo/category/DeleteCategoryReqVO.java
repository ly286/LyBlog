package com.ly.lyblogadmin.model.vo.category;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dly
 * @Date: 2025-07-27-22:15
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Tag(name = "删除分类")
public class DeleteCategoryReqVO {

    @NotNull(message = "id不能为空")
    private Long id;
}
