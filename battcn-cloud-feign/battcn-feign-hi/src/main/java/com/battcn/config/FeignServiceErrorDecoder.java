package com.battcn.config;


import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FeignServiceErrorDecoder implements feign.codec.ErrorDecoder {

    static Logger LOGGER = LoggerFactory.getLogger(FeignServiceErrorDecoder.class);

    /**
     * 关于Feign触发阻断异常
     *
     * @param methodKey
     * @param response
     * @return
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            if (response.status() >= 400 && response.status() <= 499) {
                String error = Util.toString(response.body().asReader());
                return new HystrixBadRequestException(error);
            }
        } catch (IOException e) {
            LOGGER.error("[Feign解析异常] - [{}]", e);
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }
}