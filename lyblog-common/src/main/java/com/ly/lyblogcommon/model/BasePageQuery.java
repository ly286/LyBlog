package com.ly.lyblogcommon.model;

import lombok.Data;

/**
 * @Author: dly
 * @Date: 2025-07-27-21:02
 * @Description:
 */
@Data
public class BasePageQuery {
    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;
}
