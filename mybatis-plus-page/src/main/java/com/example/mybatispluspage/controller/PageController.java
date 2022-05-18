package com.example.mybatispluspage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatispluspage.domain.Page;
import com.example.mybatispluspage.service.PageService;
import com.example.mybatispluspage.utils.PageUtils;
import com.example.mybatispluspage.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("lqs")
public class PageController {
    @Autowired
    private PageService pageService;


    /**
     * 分页查询
     * @param param
     * @return
     */
    @PostMapping("page")
    public R page(@RequestBody Map<String, Object> param){
        try{
            PageUtils pages = pageService.selecTpage(param);
            // 成功返回数据
            return R.ok().put("data", pages).put("haha", "woni");
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }
    }

    /**
     * 保存
     * @param page
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody Page page){
        try{
            for(int i = 0; i<100; i++){

                pageService.save(page);
            }
            // 成功返回数据
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }
    }






}
