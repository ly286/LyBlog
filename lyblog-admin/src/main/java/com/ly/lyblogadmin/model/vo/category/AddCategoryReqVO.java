package com.ly.lyblogadmin.model.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:39
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "添加分类VO")
public class AddCategoryReqVO {

    @NotBlank(message = "分类名不能为空")
    @Length(min = 1, max = 10, message = "分类名称字数限制 1 ~ 10 之间")
    private String name;
}
