package com.ly.lyblogadmin.model.vo.tag;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:39
 * @Description: 标签新增
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "添加标签VO")
public class AddTagReqVO {

    @NotEmpty(message = "标签集合不能为空")
    private List<String> tags;
}
