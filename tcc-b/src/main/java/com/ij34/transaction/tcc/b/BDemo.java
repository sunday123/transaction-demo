package com.ij34.transaction.tcc.b;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.ij34.transaction.tcc.b.mapper")
public class BDemo {

    public static void main(String[] args) {
        SpringApplication.run(BDemo.class, args);
    }

}