package com.li.org;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@MapperScan("com.li.org.mapper")
public class WittyZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WittyZuulApplication.class, args);
    }

}
