package com.spring.cloud.springboot;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by minghua on 2017/6/18.
 */
@RestController
public class HelloController {

    /**
     * Http请求的性能指标之一，计数器，记录增加量和减少量
     */
    @Resource
    private CounterService counterService;

    @RequestMapping("/hello")
    public String index(){
        return "Hello world";
    }

    @RequestMapping("/greet")
    public String  greet(){
        counterService.increment("hello.count");
        return "";
    }
}