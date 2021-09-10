/**
 * Huihe.com Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.wrj.springcloud.demo.serversonsumer.web;

import com.google.common.collect.Lists;
import com.wrj.springcloud.demo.serversonsumer.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String forObject = restTemplate.getForObject("http://Server-Provider/info", String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://Server-Provider/info", String.class);
        String body = forEntity.getBody();
        System.out.println(forObject);
        System.out.println(body);
        return forObject;
    }

    @GetMapping("{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        /*Map<String, Long> map = new HashMap<>();
        map.put("id", 1L);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/user/{id}").build().expand(map).encode().toUri();
        User user = restTemplate.getForObject(uri, User.class);*/
        User user = restTemplate.getForObject("http://Server-Provider/user/{id}", User.class, id);
        return user;
    }

    @GetMapping("get")
    public List getUserList() {
        List userList = restTemplate.getForObject("http://Server-Provider/user", List.class);
        return userList;
    }

    @PostMapping("add")
    public String addUser(@RequestBody User user) {
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("http://Server-Provider/user", user, null);
        HttpStatus statusCode = objectResponseEntity.getStatusCode();
        boolean xxSuccessful = statusCode.is2xxSuccessful();
        if (xxSuccessful) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @PutMapping("user/update")
    public String updateUser(@RequestBody User user) {
        restTemplate.put("http://Server-Provider/user", user);
        return "1";
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        restTemplate.delete("http://Server-Provider/user/{id}", id);
    }
}