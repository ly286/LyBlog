package com.ly.lyblogcommon.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @Author: dly
 * @Date: 2025-07-27-20:53
 * @Description:
 */
@Data
public class PageResult<T> extends Result<List<T>> {
    /**
     * 总记录数
     */
    private long total = 0L;

    /**
     * 每页显示的记录数，默认每页显示 10 条
     */
    private long size = 10L;

    /**
     * 当前页码
     */
    private long current;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 成功响应
     * @param page Mybatis Plus 提供的分页接口
     * @param data
     * @return
     * @param <T>
     */
    public static <T> PageResult<T> success(IPage<T> page, List<T> data) {
        PageResult<T> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setSize(page.getSize());
        result.setCurrent(page.getCurrent());
        result.setPages(page.getPages());
        result.setData(data);
        return result;
    }

    public static <T, R> PageResult<R> successFrom(IPage<T> page, List<R> data) {
        PageResult<R> result = new PageResult<>();
        result.setTotal(Objects.isNull(page) ? 0L : page.getTotal());
        result.setSize(Objects.isNull(page) ? 10L : page.getSize());
        result.setCurrent(Objects.isNull(page) ? 1L : page.getCurrent());
        result.setPages(Objects.isNull(page) ? 0L : page.getPages());
        result.setData(data);
        return result;
    }

}
