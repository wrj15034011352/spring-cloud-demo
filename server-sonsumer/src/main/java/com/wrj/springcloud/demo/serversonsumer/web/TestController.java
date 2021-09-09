/**
 * Huihe.com Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.wrj.springcloud.demo.serversonsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author rongjie.wang
 * @version '': TestController, v0.1 2021/9/9 15:28 rongjie.wang Exp $$
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    public String getInfo() {
        return this.restTemplate.getForEntity("http://Server-Provider/info", String.class).getBody();
    }
}