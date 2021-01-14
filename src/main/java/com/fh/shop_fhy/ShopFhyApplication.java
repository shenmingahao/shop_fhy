package com.fh.shop_fhy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.shop_fhy.dao")
public class ShopFhyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopFhyApplication.class, args);
    }

}
