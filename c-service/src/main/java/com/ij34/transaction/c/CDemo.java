package com.ij34.transaction.c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.ij34.transaction.c.mapper")
public class CDemo {

    public static void main(String[] args) {
        SpringApplication.run(CDemo.class, args);
    }

}