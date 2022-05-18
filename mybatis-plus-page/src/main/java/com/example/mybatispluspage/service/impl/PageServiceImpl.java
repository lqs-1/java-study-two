package com.example.mybatispluspage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatispluspage.domain.Page;
import com.example.mybatispluspage.mapper.PageMapper;
import com.example.mybatispluspage.service.PageService;
import com.example.mybatispluspage.utils.PageUtils;
import com.example.mybatispluspage.utils.QueryPage;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("PageService")
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
    @Override
    public PageUtils selecTpage(Map<String, Object> param) {
        IPage<Page> mapIPage = this.page(new QueryPage<Page>().getPage(param, true), null);
        return new PageUtils(mapIPage);
    }
}
