package com.battcn.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "battcn-feign-hello", fallback = ErrorClient.HelloClientFallback.class)
public interface ErrorClient {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/error")
    Long sendError(@RequestParam("id") Long id);

    @Component
    static class HelloClientFallback implements ErrorClient {
        static Logger LOGGER = LoggerFactory.getLogger(HelloClientFallback.class);
        @Override
        public Long sendError(Long id) {
            LOGGER.info("进入到了 HelloClientFallback 中....");
            return -100L;
        }
    }
}
