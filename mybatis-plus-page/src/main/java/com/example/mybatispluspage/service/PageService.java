package com.example.mybatispluspage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatispluspage.domain.Page;
import com.example.mybatispluspage.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface PageService extends IService<Page> {
    PageUtils selecTpage(Map<String, Object> param) throws Exception;
}
