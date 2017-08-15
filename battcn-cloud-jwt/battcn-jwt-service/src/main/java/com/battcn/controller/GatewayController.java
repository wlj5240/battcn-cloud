package com.battcn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@RestController
public class GatewayController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
    @GetMapping("/api/test2")
    public String test2(){
        return "test2";
    }
}
