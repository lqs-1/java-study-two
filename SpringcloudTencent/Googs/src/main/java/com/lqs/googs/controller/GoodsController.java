package com.lqs.googs.controller;

import com.lqs.common.to.RequestTo;
import com.lqs.common.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午1:35
 * @do 测试googds模块
 */

@RestController
@RequestMapping("goods")
public class GoodsController {

    @GetMapping("goods")
    public R getGoods(){
        return R.ok().put("goods", "haha_goods");
    }
    @GetMapping("local")
    public R local(){
        return R.ok().put("goods", "local_googs");
    }

    @PostMapping("plusLoacl")
    public R plusLocal(@RequestBody RequestTo requestTo){
        return R.ok().put("goods", requestTo);
    }


}
