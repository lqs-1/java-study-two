package com.example.mybatispluspage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatispluspage.domain.Page;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PageMapper extends BaseMapper<Page> {
}
