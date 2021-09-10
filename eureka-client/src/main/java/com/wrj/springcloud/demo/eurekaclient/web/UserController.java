/**
 * Huihe.com Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.wrj.springcloud.demo.eurekaclient.web;

import com.google.common.collect.Lists;
import com.wrj.springcloud.demo.eurekaclient.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rongjie.wang
 * @version '': UserController, v0.1 2021/9/9 17:24 rongjie.wang Exp $$
 */
@RestController
@RequestMapping("user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("{id:\\d+}")
    public User get(@PathVariable Long id) {
        log.info("请求的id是-" + id);
        return new User(id, "wrj", "wrj");
    }

    @GetMapping
    public List<User> get() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "mrbird", "123456"));
        list.add(new User(2L, "scott", "123456"));
        log.info("获取用户信息 " + list);
        return list;
    }

    @PostMapping
    public void add(@RequestBody User user) {
        log.info("新增用户成功 " + user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        log.info("更新用户成功 " + user);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }
}