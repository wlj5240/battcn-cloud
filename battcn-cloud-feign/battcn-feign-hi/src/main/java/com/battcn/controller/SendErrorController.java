package com.battcn.controller;

import com.battcn.client.ErrorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class SendErrorController {

    @Autowired
    ErrorClient errorClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Long send(Long id) {
        // TODO：只是演示Feign 异常情况
        return errorClient.sendError(id);
    }


}
