package com.ly.lyblogcommon.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dly
 * @Date: 2025-07-27-23:22
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectRspVO {
    /**
     * Select 下拉列表的展示文字
     */
    private String label;

    /**
     * Select 下拉列表的 value 值，如 ID 等
     */
    private Object value;
}

