package com.ly.lyblogadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.lyblogadmin.model.vo.tag.AddTagReqVO;
import com.ly.lyblogadmin.service.AdminTagService;
import com.ly.lyblogcommon.domain.dos.TagDO;
import com.ly.lyblogcommon.domain.mapper.TagMapper;
import com.ly.lyblogcommon.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dly
 * @Date: 2025-07-26-22:49
 * @Description:
 */
@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {

    @Autowired
    private TagMapper tagMapper;

    /*
    * 添加标签
    * @param addTagReqVO
    * @return
    * */
    @Override
    public Result addTag(AddTagReqVO addTagReqVO) {
        // vo -> do
        List<TagDO> tagDOS = addTagReqVO.getTags()
                .stream().map(tagName -> TagDO.builder()
                        .name(tagName.trim()) // 去空格
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());

        // 批量插入数据
        try {
            saveBatch(tagDOS);
        } catch (Exception e) {
            log.warn("添加标签失败", e);
        }


        return Result.success();
    }
}

