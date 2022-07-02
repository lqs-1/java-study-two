package com.lqs.user.feign;

import com.lqs.common.to.RequestTo;
import com.lqs.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午3:12
 * @do 向goods发起远程调用的服务
 */

// 写清楚被调用的微服务的名字
@FeignClient("googs")
public interface GoodsFeignServer {

    // 这个接口中所有的方法都和googs中对应的方法同名，请求方法和请求路径也是一样的，在使用的时候就和调用service一模一样
    @GetMapping ("/goods/local")
    R local();

    // 如果被调用的其他微服务有参数，那么照抄
    @PostMapping("/goods/plusLoacl")
    public R plusLocal(@RequestBody RequestTo requestTo);
}
