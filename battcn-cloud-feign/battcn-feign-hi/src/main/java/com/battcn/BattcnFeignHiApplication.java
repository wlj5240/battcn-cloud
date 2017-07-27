package com.battcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.battcn.client."})
@EnableHystrix
@SpringCloudApplication
public class BattcnFeignHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BattcnFeignHiApplication.class, args);
    }
}
