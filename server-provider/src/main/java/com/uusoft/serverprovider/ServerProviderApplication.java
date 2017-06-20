package com.uusoft.serverprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by minghua on 2017/6/21.
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class ServerProviderApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder(ServerProviderApplication.class).web(true).run(args);
    }


    @RequestMapping("/hello")
    public String hello(){
        return "ceshi lllllllllllllll";
    }
}
