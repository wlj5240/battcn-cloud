package com.battcn.controller;

import com.battcn.client.ErrorClient;
import com.battcn.exception.BattcnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/error")
public class ErrorController implements ErrorClient {

    static Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Long sendError(Long id) {
        LOGGER.info("[正确情况] - [返回100]");
        if (Objects.equals(id, 1L))
            throw new BattcnException("我是 ErrorController 不是 Fallback ");
        return 100L;
    }
}
